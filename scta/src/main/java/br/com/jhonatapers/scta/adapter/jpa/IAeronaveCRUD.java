package br.com.jhonatapers.scta.adapter.jpa;

import br.com.jhonatapers.scta.domain.entity.Aeronave;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IAeronaveCRUD extends CrudRepository<Aeronave, String> {
    Optional<Aeronave> findByPrefixo(String prefixo);
}
