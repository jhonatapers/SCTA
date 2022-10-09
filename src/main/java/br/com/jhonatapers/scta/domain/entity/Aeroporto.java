package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.jhonatapers.scta.domain.aggregate.ReferenciaGeografica;

@Entity
public class Aeroporto {

    @Id
    private final String codigoAeroporturario; 

    private String nome;
    
    private ReferenciaGeografica coordenada;

    public Aeroporto(String codigoAeroporturario, String nome, ReferenciaGeografica coordenada) {
        this.codigoAeroporturario = codigoAeroporturario;
        this.nome = nome;
        this.coordenada = coordenada;
    }

    public String getCodigoAeroporturario() {
        return codigoAeroporturario;
    }

    public String getNome() {
        return nome;
    }

    public ReferenciaGeografica getCoordenada() {
        return coordenada;
    }

}
