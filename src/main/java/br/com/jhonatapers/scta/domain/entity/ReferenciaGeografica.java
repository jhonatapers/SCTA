package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ReferenciaGeografica {

    @Id
    private String nome;

    private long latitude;

    private  long longitude;

    public ReferenciaGeografica() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReferenciaGeografica that)) return false;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
