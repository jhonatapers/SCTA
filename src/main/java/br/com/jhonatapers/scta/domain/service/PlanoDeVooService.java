package br.com.jhonatapers.scta.domain.service;

import java.util.List;

import br.com.jhonatapers.scta.domain.dto.PlanoDeVooDto;
import br.com.jhonatapers.scta.domain.dto.ValidacaoPlanoDeVooDto;
import br.com.jhonatapers.scta.domain.entity.Aeroporto;
import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import br.com.jhonatapers.scta.domain.entity.Rota;
import br.com.jhonatapers.scta.domain.repository.IPlanoDeVooRepository;

public class PlanoDeVooService {

    private final IPlanoDeVooRepository repository;

    private final RotasService rotasService;

    private final AeroviaService aeroviaService;

    private final AeroportoService aeroportoService;

    public PlanoDeVooService(IPlanoDeVooRepository repository, RotasService rotasService,
            AeroviaService aeroviaService, AeroportoService aeroportoService) {
        this.repository = repository;
        this.rotasService = rotasService;
        this.aeroviaService = aeroviaService;
        this.aeroportoService = aeroportoService;
    }

    public PlanoDeVoo cadastrar(PlanoDeVooDto planoDeVooDto) {

        if (!verificar(planoDeVooDto).isValid()) {
            throw new RuntimeException("Plano de Voo inválido");
        }

        Rota rota = rotasService.getRota(planoDeVooDto.getRotaId()).orElseThrow(() -> {
            throw new RuntimeException("Rota inexistente");
        });

        Aeroporto origem = aeroportoService.buscar(planoDeVooDto.getCodigoAeroportuarioOrigem())
                .orElseThrow(() -> new RuntimeException("Aeroporto origem não encontrado"));

        Aeroporto destino = aeroportoService.buscar(planoDeVooDto.getCodigoAeroportuarioDestino())
                .orElseThrow(() -> new RuntimeException("Aeroporto destino não encontrado"));

        rotasService.ocupaRota(
                rota,
                planoDeVooDto.getDataHora(),
                planoDeVooDto.getAltitude(),
                planoDeVooDto.getVelocidadeCruzeiro());

        return repository.save(new PlanoDeVoo(planoDeVooDto.getDataHora(), rota, planoDeVooDto.getAltitude(),
                planoDeVooDto.getVelocidadeCruzeiro(), origem, destino));
    }

    public void cancelar(Long idPlanoDeVoo) {
        final PlanoDeVoo planoDeVoo = buscar(idPlanoDeVoo);

        rotasService.desocupaRota(
                planoDeVoo.getRota(),
                planoDeVoo.getDataHora(),
                planoDeVoo.getAltitude(),
                planoDeVoo.getVelocidadeCruzeiro());

        planoDeVoo.setCancelado(true);

        repository.save(planoDeVoo);
    }

    public PlanoDeVoo buscar(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano de Voo não encontrado"));
    }

    public List<PlanoDeVoo> todos() {
        return repository.findAll();
    }

    public ValidacaoPlanoDeVooDto verificar(PlanoDeVooDto planoDeVooDto) {

        ValidacaoPlanoDeVooDto validacaoPlanoDeVooDto = new ValidacaoPlanoDeVooDto();
        validacaoPlanoDeVooDto.setIsValid(true);

        if (planoDeVooDto.getAltitude() > 35000 || planoDeVooDto.getAltitude() < 25000)
            validacaoPlanoDeVooDto.addProblema("Altitude invalida");

        if (planoDeVooDto.getVelocidadeCruzeiro() < 1) {
            validacaoPlanoDeVooDto.addProblema("Velocidade de cruzeiro invalida");
        } else {

            Rota rota = rotasService.getRota(planoDeVooDto.getRotaId()).orElseThrow(() -> {
                throw new RuntimeException("Rota inexistente");
            });

            Aeroporto origem = aeroportoService.buscar(planoDeVooDto.getCodigoAeroportuarioOrigem())
                    .orElseThrow(() -> new RuntimeException("Aeroporto origem não encontrado"));

            for (String problema : aeroviaService.validacao(rota.getAerovias(),
                    origem.getCoordenada(), planoDeVooDto.getDataHora(),
                    planoDeVooDto.getAltitude(), planoDeVooDto.getVelocidadeCruzeiro())) {
                validacaoPlanoDeVooDto.addProblema(problema);
            }
        }

        return validacaoPlanoDeVooDto;
    }

}
