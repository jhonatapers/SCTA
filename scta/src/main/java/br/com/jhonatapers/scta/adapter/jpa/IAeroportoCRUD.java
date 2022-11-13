package br.com.jhonatapers.scta.adapter.jpa;

import br.com.jhonatapers.scta.domain.entity.Aeroporto;
import org.springframework.data.repository.CrudRepository;

public interface IAeroportoCRUD extends CrudRepository<Aeroporto, String> {
}
