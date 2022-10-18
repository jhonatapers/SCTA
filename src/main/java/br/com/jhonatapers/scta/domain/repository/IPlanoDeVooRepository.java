package br.com.jhonatapers.scta.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;

public interface IPlanoDeVooRepository {
    
    Optional<PlanoDeVoo> findById(long id);

    List<PlanoDeVoo> findAll();

    PlanoDeVoo save(PlanoDeVoo planoDeVoo);

}
