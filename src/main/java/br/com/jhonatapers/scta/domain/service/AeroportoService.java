package br.com.jhonatapers.scta.domain.service;

import java.util.Optional;

import br.com.jhonatapers.scta.domain.entity.Aeroporto;
import br.com.jhonatapers.scta.domain.repository.IAeroportoRepository;

public class AeroportoService {

    private final IAeroportoRepository aeroportoRepository;

    public AeroportoService(IAeroportoRepository aeroportoRepository) {
        this.aeroportoRepository = aeroportoRepository;
    }

    public Optional<Aeroporto> buscar(String codigoAeroportuario) {
        return aeroportoRepository.findByCodigoAeroporturario(codigoAeroportuario);
    }
}
