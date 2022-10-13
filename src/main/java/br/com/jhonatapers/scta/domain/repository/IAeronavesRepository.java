package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.Aeronave;

public interface IAeronavesRepository {
    
    public Aeronave findByPrefixo(String prefixo);

}
