package br.com.jhonatapers.scta.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jhonatapers.scta.domain.entity.Aeronave;
import br.com.jhonatapers.scta.domain.repository.IAeronavesRepository;

public class AeronavesService {

    @Autowired
    private IAeronavesRepository repository;

    public Aeronave buscar(String prefixo) {
        return repository.findByPrefixo(prefixo)
                .orElseThrow(() -> new RuntimeException("Não achei"));
    }

}
