package br.com.jhonatapers.scta.adapter.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;

public interface IPlanoDeVooCRUD extends CrudRepository<PlanoDeVoo, Long> {

    List<PlanoDeVoo> findAll();

    Optional<PlanoDeVoo> findById(long id);

    PlanoDeVoo update(PlanoDeVoo planoDeVoo);

    PlanoDeVoo remove(PlanoDeVoo remove);
}
