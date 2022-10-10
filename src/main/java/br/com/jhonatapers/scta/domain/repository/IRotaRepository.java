package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.Rota;

import java.util.List;

public interface IRotaRepository {

    public List<Rota> findAll();

    public Rota findById(long id);

    public Rota save(Rota rota);

    public void remove(Rota rota);
    
}
