package br.com.jhonatapers.scta.adapter.repository;

import br.com.jhonatapers.scta.adapter.jpa.IAeronaveCRUD;
import br.com.jhonatapers.scta.domain.entity.Aeronave;
import br.com.jhonatapers.scta.domain.repository.IAeronavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AeronavesRepositoryImpl implements IAeronavesRepository {

    private IAeronaveCRUD aeronaveCRUD;

    @Autowired
    public AeronavesRepositoryImpl(IAeronaveCRUD aeronaveCRUD) {
        this.aeronaveCRUD = aeronaveCRUD;
    }

    public Optional<Aeronave> findByPrefixo(String prefixo) {
        return aeronaveCRUD.findByPrefixo(prefixo);
    }
 
}
