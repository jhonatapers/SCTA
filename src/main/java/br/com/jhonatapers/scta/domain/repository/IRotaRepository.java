package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.Rota;

public interface IRotaRepository {

    public Rota findById(long id);

    public Rota save(Rota rota);

    public void remove(Rota rota);
    
}
