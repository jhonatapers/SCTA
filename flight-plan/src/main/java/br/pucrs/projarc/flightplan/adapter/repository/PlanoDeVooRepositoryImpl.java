package br.pucrs.projarc.flightplan.adapter.repository;

import br.pucrs.projarc.flightplan.adapter.jpa.PlanoDeVooCRUD;
import br.pucrs.projarc.flightplan.domain.entity.PlanoDeVoo;
import br.pucrs.projarc.flightplan.domain.repository.IPlanoDeVooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlanoDeVooRepositoryImpl implements IPlanoDeVooRepository {

    private final PlanoDeVooCRUD planoDeVooCRUD;

    @Autowired
    public PlanoDeVooRepositoryImpl(PlanoDeVooCRUD planoDeVooCRUD) {
        this.planoDeVooCRUD = planoDeVooCRUD;
    }

    @Override
    public Optional<PlanoDeVoo> findById(long id) {
        return planoDeVooCRUD.findById(id);
    }

    @Override
    public PlanoDeVoo save(PlanoDeVoo planoDeVoo) {
        return planoDeVooCRUD.save(planoDeVoo);
    }
}