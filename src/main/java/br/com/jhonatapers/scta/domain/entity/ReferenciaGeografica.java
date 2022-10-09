package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReferenciaGeografica {

    @Id
    private final String nome;

    private final long latitude;

    private final long longitude;

    public ReferenciaGeografica(String nome, long latitude, long longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public long getLatitude() {
        return latitude;
    }

    public long getLongitude() {
        return longitude;
    }

}
