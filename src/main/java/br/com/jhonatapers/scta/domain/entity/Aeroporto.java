package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Aeroporto {

    @Id
    private String codigoAeroportuario;

    private String nome;

    @OneToOne
    @JoinColumn(name = "referencia_id", referencedColumnName = "nome")
    private ReferenciaGeografica coordenada;

    public Aeroporto() {
    }

    public Aeroporto(String codigoAeroportuario, String nome, ReferenciaGeografica coordenada) {
        this.codigoAeroportuario = codigoAeroportuario;
        this.nome = nome;
        this.coordenada = coordenada;
    }

    public String getCodigoAeroportuario() {
        return codigoAeroportuario;
    }

    public String getNome() {
        return nome;
    }

    public ReferenciaGeografica getCoordenada() {
        return coordenada;
    }

}
