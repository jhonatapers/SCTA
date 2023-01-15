package br.pucrs.projarc.flightplan.adapter.jpa;

import br.pucrs.projarc.flightplan.domain.entity.PlanoDeVoo;
import org.springframework.data.repository.CrudRepository;

public interface PlanoDeVooCRUD extends CrudRepository<PlanoDeVoo, Long> {
}
