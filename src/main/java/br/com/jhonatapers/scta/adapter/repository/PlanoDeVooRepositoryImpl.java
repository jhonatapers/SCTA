package br.com.jhonatapers.scta.adapter.repository;

import java.util.List;
import java.util.Optional;

import br.com.jhonatapers.scta.adapter.jpa.IPlanoDeVooCRUD;
import br.com.jhonatapers.scta.domain.repository.IPlanoDeVooRepository;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import org.springframework.stereotype.Component;

@Component
public class PlanoDeVooRepositoryImpl implements IPlanoDeVooRepository {

    private IPlanoDeVooCRUD planoDeVooCRUD;

    @Autowired
    public PlanoDeVooRepositoryImpl(IPlanoDeVooCRUD planoDeVooCRUD) {
        this.planoDeVooCRUD = planoDeVooCRUD;
    }

    public Optional<PlanoDeVoo> findById(long id) {
        return planoDeVooCRUD.findById(id);
    }

    public List<PlanoDeVoo> findAll() {
        return planoDeVooCRUD.findAll();
    }

    public PlanoDeVoo save(PlanoDeVoo planoDeVoo) {
        return planoDeVooCRUD.save(planoDeVoo);
    }

    public PlanoDeVoo update(PlanoDeVoo planoDeVoo) {
        return planoDeVooCRUD.update(planoDeVoo);
    }

    public void remove(PlanoDeVoo planoDeVoo) {
        planoDeVooCRUD.remove(planoDeVoo);
    }
}