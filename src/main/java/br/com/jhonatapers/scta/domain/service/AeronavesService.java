package br.com.jhonatapers.scta.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jhonatapers.scta.domain.entity.Aeronave;
import br.com.jhonatapers.scta.domain.repository.IAeronavesRepository;

public class AeronavesService {

    @Autowired
    private IAeronavesRepository repository;

    public Aeronave criar(Aeronave aeronave) {

        Aeronave _aeronave = buscar(aeronave.getPrefixo());

        if (_aeronave == null)
            return repository.save(aeronave);
        else
            return _aeronave;
    }

    public void remover(Aeronave aeronave) {
        repository.remove(aeronave);
    }

    public Aeronave buscar(String prefixo) {
        return repository.findByPrefixo(prefixo);
    }

}
