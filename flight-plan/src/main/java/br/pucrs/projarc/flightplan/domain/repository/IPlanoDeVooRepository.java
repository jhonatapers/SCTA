package br.pucrs.projarc.flightplan.domain.repository;

import br.pucrs.projarc.flightplan.domain.entity.PlanoDeVoo;

import java.util.Optional;

public interface IPlanoDeVooRepository {

    Optional<PlanoDeVoo> findById(long id);

    PlanoDeVoo save(PlanoDeVoo planoDeVoo);

}
