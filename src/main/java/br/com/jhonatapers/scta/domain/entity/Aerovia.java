package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;

@Entity
public class Aerovia {
    
    private Coordenada extremoInicio;

    private Coordenada extremoFinal;

    public Aerovia(Coordenada extremoInicio, Coordenada extremoFinal) {
        this.extremoInicio = extremoInicio;
        this.extremoFinal = extremoFinal;
    }

    public Coordenada getExtremoInicio() {
        return extremoInicio;
    }

    public void setExtremoInicio(Coordenada extremoInicio) {
        this.extremoInicio = extremoInicio;
    }

    public Coordenada getExtremoFinal() {
        return extremoFinal;
    }

    public void setExtremoFinal(Coordenada extremoFinal) {
        this.extremoFinal = extremoFinal;
    }

}
