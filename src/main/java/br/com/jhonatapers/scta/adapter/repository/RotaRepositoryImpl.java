package br.com.jhonatapers.scta.adapter.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jhonatapers.scta.domain.entity.Rota;
import br.com.jhonatapers.scta.domain.repository.IRotaRepository;

public class RotaRepositoryImpl implements IRotaRepository {

    private IRotaCRUD rotaCRUD;

    @Autowired
    public RotaRepositoryImpl(IRotaCRUD rotaCRUD) {
        this.rotaCRUD = rotaCRUD;
    }

    public List<Rota> findAll() {
        return rotaCRUD.findAll();
    }
}