package br.com.jhonatapers.scta.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rota {
    
    @Id
    private long id;
    
    private List<Aerovia> aerovias;

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
