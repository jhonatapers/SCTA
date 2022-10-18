package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.Aeronave;

import java.util.Optional;

public interface IAeronavesRepository {
    
    Optional<Aeronave> findByPrefixo(String prefixo);

}
