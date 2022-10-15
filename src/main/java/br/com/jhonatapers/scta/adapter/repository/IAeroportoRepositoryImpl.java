package br.com.jhonatapers.scta.adapter.repository;

import br.com.jhonatapers.scta.adapter.jpa.IAeroportoCRUD;
import br.com.jhonatapers.scta.domain.entity.Aeroporto;
import br.com.jhonatapers.scta.domain.repository.IAeroportoRepository;

import java.util.Optional;

public class IAeroportoRepositoryImpl implements IAeroportoRepository {

    private final IAeroportoCRUD aeroportoCRUD;

    public IAeroportoRepositoryImpl(IAeroportoCRUD aeroportoCRUD) {
        this.aeroportoCRUD = aeroportoCRUD;
    }

    @Override
    public Optional<Aeroporto> findByCodigoAeroporturario(String codigoAeroporturario) {
        return aeroportoCRUD.findById(codigoAeroporturario);
    }
}
