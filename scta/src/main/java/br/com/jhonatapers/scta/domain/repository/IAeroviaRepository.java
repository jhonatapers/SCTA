package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.Aerovia;

import java.util.Optional;

public interface IAeroviaRepository {

    Optional<Aerovia> findByNome(String nome);

    Aerovia update(Aerovia aerovia);

}
