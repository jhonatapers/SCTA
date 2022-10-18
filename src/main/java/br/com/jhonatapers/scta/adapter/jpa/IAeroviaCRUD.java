package br.com.jhonatapers.scta.adapter.jpa;

import org.springframework.data.repository.CrudRepository;

import br.com.jhonatapers.scta.domain.entity.Aerovia;

import java.util.Optional;


public interface IAeroviaCRUD extends CrudRepository<Aerovia, Long> {

    Optional<Aerovia> findByNome(String nome);
}
