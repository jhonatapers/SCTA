package br.com.jhonatapers.scta.domain.service;

import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import br.com.jhonatapers.scta.domain.repository.IPlanoDeVooRepository;

public class PlanoDeVooService {

    private IPlanoDeVooRepository repository;

    public PlanoDeVoo criar(PlanoDeVoo planoDeVoo) {
        PlanoDeVoo _planoDeVoo = repository.findById(planoDeVoo.getId());

        if (_planoDeVoo == null)
            return repository.save(planoDeVoo);
        else
            return _planoDeVoo;
    }

    public void remover(PlanoDeVoo planoDeVoo) {
        repository.remove(planoDeVoo);
    }

    public PlanoDeVoo buscar(long id) {
        return repository.findById(id);
    }

}
