package br.com.jhonatapers.scta.domain.service;

import java.util.List;
import java.util.Optional;

import br.com.jhonatapers.scta.domain.dto.ValidacaoPlanoDeVooDto;
import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import br.com.jhonatapers.scta.domain.repository.IPlanoDeVooRepository;

public class PlanoDeVooService {

    private final IPlanoDeVooRepository repository;

    private final RotasService rotasService;

    private final AeroviaService aeroviaService;

    public PlanoDeVooService(IPlanoDeVooRepository repository, RotasService rotasService, AeroviaService aeroviaService) {
        this.repository = repository;
        this.rotasService = rotasService;
        this.aeroviaService = aeroviaService;
    }

    public PlanoDeVoo cadastrar(PlanoDeVoo planoDeVoo) {
        Optional<PlanoDeVoo> _planoDeVoo = repository.findById(planoDeVoo.getId());

        if (_planoDeVoo.isEmpty()) {
            if (verificar(planoDeVoo).isValid()) {
                rotasService.ocupaRota(
                        planoDeVoo.getRota(),
                        planoDeVoo.getDataHora(),
                        planoDeVoo.getAltitude(),
                        planoDeVoo.getVelocidadeCruzeiro());

                return repository.save(planoDeVoo);
            }
        }

        return _planoDeVoo.get();
    }

    public void cancelar(PlanoDeVoo planoDeVoo) {
        PlanoDeVoo _planoDeVoo = buscar(planoDeVoo.getId());

        rotasService.desocupaRota(
                _planoDeVoo.getRota(),
                _planoDeVoo.getDataHora(),
                _planoDeVoo.getAltitude(),
                _planoDeVoo.getVelocidadeCruzeiro());

        _planoDeVoo.setCancelado(true);

        repository.save(_planoDeVoo);
    }

    public PlanoDeVoo buscar(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano de Voo não encontrado"));
    }

    public List<PlanoDeVoo> todos() {
        return repository.findAll();
    }

    public ValidacaoPlanoDeVooDto verificar(PlanoDeVoo planoDeVoo) {

        ValidacaoPlanoDeVooDto validacaoPlanoDeVooDto = new ValidacaoPlanoDeVooDto();

        if (planoDeVoo.getAltitude() > 35000 || planoDeVoo.getAltitude() < 25000)
            validacaoPlanoDeVooDto.addProblema("Altitude invalida");

        if (planoDeVoo.getVelocidadeCruzeiro() < 1) {
            validacaoPlanoDeVooDto.addProblema("Velocidade de cruzeiro invalida");
        } else {

            for (String problema : aeroviaService.validacao(planoDeVoo.getRota().getAerovias(),
                    planoDeVoo.getAeroportoOrigem().getCoordenada(), planoDeVoo.getDataHora(),
                    planoDeVoo.getAltitude(), planoDeVoo.getVelocidadeCruzeiro())) {
                validacaoPlanoDeVooDto.addProblema(problema);
            }
        }

        return validacaoPlanoDeVooDto;
    }

}
