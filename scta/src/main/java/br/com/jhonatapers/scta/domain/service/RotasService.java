package br.com.jhonatapers.scta.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import br.com.jhonatapers.scta.domain.entity.Aeroporto;
import br.com.jhonatapers.scta.domain.entity.ReferenciaGeografica;
import br.com.jhonatapers.scta.domain.entity.Rota;
import br.com.jhonatapers.scta.domain.repository.IRotaRepository;

public class RotasService {

    AeroviaService aeroviaService;

    IRotaRepository repository;

    private AeroportoService aeroportoService;


    public RotasService(AeroviaService aeroviaService,
                        IRotaRepository repository,
                        AeroportoService aeroportoService) {
        this.aeroviaService = aeroviaService;
        this.repository = repository;
        this.aeroportoService = aeroportoService;
    }

    public List<Rota> consultarEntreAeroportos(String codigoAeroportuarioOrigem, String codigoAeroportuarioDestino) {

        final Aeroporto aeroportoOrigem = aeroportoService.buscar(codigoAeroportuarioOrigem);
        final Aeroporto aeroportoDestino = aeroportoService.buscar(codigoAeroportuarioDestino);

        List<Rota> rotas = repository.findAll();

        final ReferenciaGeografica refOrigem = aeroportoOrigem.getCoordenada();
        final ReferenciaGeografica refDestino = aeroportoDestino.getCoordenada();

        List<Rota> rotasNaOrigem = rotas
                .stream()
                .filter(rota -> rota.getAerovias()
                        .stream()
                        .filter(aerovia -> aerovia.getExtremoFinal().equals(refOrigem)
                                || aerovia.getExtremoInicio().equals(refOrigem))
                        .findFirst()
                        .isPresent())
                .toList();

        List<Rota> interseccaoRotas = rotasNaOrigem
                .stream()
                .filter(rota -> rota.getAerovias()
                        .stream()
                        .filter(aerovia -> aerovia.getExtremoFinal().equals(refDestino)
                                || aerovia.getExtremoInicio().equals(refDestino))
                        .findFirst()
                        .isPresent()).toList();

        return interseccaoRotas;
    }

    public void ocupaRota(Rota rota, LocalDateTime dataHora, float altitude, float velocidadeCruzeiro) {
        aeroviaService.ocupaSlotHorario(rota.getAerovias(), dataHora, altitude, velocidadeCruzeiro);
    }

    public void desocupaRota(Rota rota, LocalDateTime dataHora, float altitude, float velocidadeCruzeiro) {
        aeroviaService.desocupaSlotHorario(rota.getAerovias(), dataHora, altitude, velocidadeCruzeiro);
    }

}
