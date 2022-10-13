package br.com.jhonatapers.scta.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import br.com.jhonatapers.scta.domain.repository.IPlanoDeVooRepository;

public class PlanoDeVooService {

    @Autowired
    private IPlanoDeVooRepository repository;

    @Autowired
    private RotasService rotasService;

    public PlanoDeVoo cadastrar(PlanoDeVoo planoDeVoo) {
        Optional<PlanoDeVoo> _planoDeVoo = repository.findById(planoDeVoo.getId());

        if (_planoDeVoo.isEmpty()) {
            if (verificar(planoDeVoo)) {
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

        repository.update(_planoDeVoo);
    }

    public PlanoDeVoo buscar(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano de Voo não encontrado"));
    }

    public List<PlanoDeVoo> todos() {
        return repository.findAll();
    }

    public boolean verificar(PlanoDeVoo planoDeVoo) {
        return true;//esperar email
    }

}
