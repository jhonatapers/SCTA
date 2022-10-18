package br.com.jhonatapers.scta.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Rota {
    
    @Id
    private long id;

    @ManyToMany
    private List<Aerovia> aerovias;

    public Rota() {
    }

    public Rota(List<Aerovia> aerovias) {
        this.aerovias = aerovias;
    }

    public long getId() {
        return id;
    }

    public List<Aerovia> getAerovias() {
        return aerovias;
    }

}
