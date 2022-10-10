package br.com.jhonatapers.scta.domain.service;

import java.util.LinkedList;
import java.util.List;

import br.com.jhonatapers.scta.domain.entity.Aeroporto;
import br.com.jhonatapers.scta.domain.entity.Rota;
import br.com.jhonatapers.scta.domain.repository.IRotaRepository;

public class RotasService {

    IRotaRepository repository;

    public Rota buscar(long id) {
        return repository.findById(id);
    }

    public Rota criar(Rota rota) {
        Rota _rota = buscar(rota.getId());

        if (_rota == null)
            return repository.save(rota);
        else
            return _rota;
    }

    public List<Rota> consultarEntreAeroportos(Aeroporto origem, Aeroporto destino) {

        List<Rota> rotas = repository.findAll();


        return rotas;
    }



}
