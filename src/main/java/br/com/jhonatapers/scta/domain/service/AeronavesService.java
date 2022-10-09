package br.com.jhonatapers.scta.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jhonatapers.scta.domain.entity.Aeronave;
import br.com.jhonatapers.scta.domain.repository.IAeronavesRepository;

public class AeronavesService {

    @Autowired
    private IAeronavesRepository repository;

    public Aeronave novaAeronave(Aeronave aeronave) {

        Aeronave _aeronave = repository.findByPrefixo(aeronave.getPrefixo());

        if (_aeronave == null)
            return repository.save(aeronave);
        else
            return _aeronave;
    }

    public void removerAeronave(Aeronave aeronave) {
        repository.remove(aeronave);
    }

    public Aeronave buscaAeronave(String prefixo) {
        Aeronave aeronave = repository.findByPrefixo(prefixo);
        return aeronave;
    }

}
