package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;

@Entity
public class Aeroporto {
    
    private Coordenada coordenada;

    public Aeroporto(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

}
