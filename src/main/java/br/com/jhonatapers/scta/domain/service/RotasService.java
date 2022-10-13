package br.com.jhonatapers.scta.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jhonatapers.scta.domain.entity.Aeroporto;
import br.com.jhonatapers.scta.domain.entity.ReferenciaGeografica;
import br.com.jhonatapers.scta.domain.entity.Rota;
import br.com.jhonatapers.scta.domain.repository.IRotaRepository;

public class RotasService {

    @Autowired
    AeroviaService aeroviaService;

    @Autowired
    IRotaRepository repository;

    public List<Rota> consultarEntreAeroportos(Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino) {

        List<Rota> rotas = repository.findAll();

        final ReferenciaGeografica refOrigem = aeroportoOrigem.getCoordenada();
        final ReferenciaGeografica refDestino = aeroportoDestino.getCoordenada();

        List<Rota> rotasNaOrigem = rotas
                .stream()
                .filter(rota -> {
                    return rota.getAerovias()
                            .stream()
                            .filter(aerovia -> {
                                return aerovia.getExtremoFinal().equals(refOrigem)
                                        || aerovia.getExtremoInicio().equals(refOrigem);
                            })
                            .findFirst()
                            .isPresent();
                })
                .toList();

        List<Rota> interseccaoRotas = rotasNaOrigem
                .stream()
                .filter(rota -> {
                    return rota.getAerovias()
                            .stream()
                            .filter(aerovia -> {
                                return aerovia.getExtremoFinal().equals(refDestino)
                                        || aerovia.getExtremoInicio().equals(refDestino);
                            })
                            .filter(null)
                            .findFirst()
                            .isPresent();
                }).toList();

        return interseccaoRotas;
    }

    public void ocupaRota(Rota rota, LocalDateTime dataHora, float altitude, float velocidadeCruzeiro) {
        aeroviaService.ocupaSlotHorario(rota.getAerovias(), dataHora, altitude, velocidadeCruzeiro);
    }

    public void desocupaRota(Rota rota, LocalDateTime dataHora, float altitude, float velocidadeCruzeiro) {
        aeroviaService.desocupaSlotHorario(rota.getAerovias(), dataHora, altitude, velocidadeCruzeiro);
    }

}
