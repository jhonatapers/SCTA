package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;

public interface IPlanoDeVooRepository {
    
    public PlanoDeVoo findById(long id);

    public PlanoDeVoo save(PlanoDeVoo aeronave);

    public PlanoDeVoo update(PlanoDeVoo aeronave);

    public void remove(PlanoDeVoo aeronave);

}
