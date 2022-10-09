package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ReferenciaGeografica getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(ReferenciaGeografica coordenada) {
        this.coordenada = coordenada;
    }

}
