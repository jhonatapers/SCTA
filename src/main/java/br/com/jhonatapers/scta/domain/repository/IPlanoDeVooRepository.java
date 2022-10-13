package br.com.jhonatapers.scta.domain.repository;

import java.util.List;
import java.util.Optional;

import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;

public interface IPlanoDeVooRepository {
    
    public Optional<PlanoDeVoo> findById(long id);

    public List<PlanoDeVoo> findAll();

    public PlanoDeVoo save(PlanoDeVoo planoDeVoo);

    public PlanoDeVoo update(PlanoDeVoo planoDeVoo);

    public void remove(PlanoDeVoo planoDeVoo);

}
