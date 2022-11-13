package br.com.jhonatapers.scta.adapter.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.jhonatapers.scta.domain.entity.Rota;

public interface IRotaCRUD extends CrudRepository<Rota, Long> {

    List<Rota> findAll();

}
