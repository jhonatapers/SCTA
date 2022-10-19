package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.Rota;

import java.util.List;
import java.util.Optional;

public interface IRotaRepository {

    public List<Rota> findAll();

    public Optional<Rota> findById(long rotaId);

}
