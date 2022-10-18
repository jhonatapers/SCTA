package br.com.jhonatapers.scta.adapter.repository;

import br.com.jhonatapers.scta.adapter.jpa.IAeroviaCRUD;
import br.com.jhonatapers.scta.domain.entity.Aerovia;
import br.com.jhonatapers.scta.domain.repository.IAeroviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AeroviaRepositoryImpl implements IAeroviaRepository {

    private IAeroviaCRUD aeroviaCRUD;

    @Autowired
    public AeroviaRepositoryImpl(IAeroviaCRUD aeroviaCRUD) {
        this.aeroviaCRUD = aeroviaCRUD;
    }

    public Optional<Aerovia> findByNome(String nome) {
        return aeroviaCRUD.findByNome(nome);
    }

    public Aerovia update(Aerovia aerovia) {
        return aeroviaCRUD.save(aerovia);
    }
}
