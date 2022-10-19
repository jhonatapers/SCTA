package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.Aeroporto;

import java.util.Optional;

public interface IAeroportoRepository {
    Optional<Aeroporto> findByCodigoAeroportuario(String idAeroporto);
}
