package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.Rota;

import java.util.List;

public interface IRotaRepository {

    public List<Rota> findAll();

}
