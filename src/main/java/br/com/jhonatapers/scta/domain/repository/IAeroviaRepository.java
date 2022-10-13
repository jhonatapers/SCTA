package br.com.jhonatapers.scta.domain.repository;

import br.com.jhonatapers.scta.domain.entity.Aerovia;

public interface IAeroviaRepository {

    public Aerovia findByNome(String nome);

    public Aerovia update(Aerovia aerovia);

}
