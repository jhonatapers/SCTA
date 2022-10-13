package br.com.jhonatapers.scta.adapter.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.jhonatapers.scta.domain.entity.Aerovia;

public interface IAeroviaCRUD extends CrudRepository<Aerovia, Long> {

}
