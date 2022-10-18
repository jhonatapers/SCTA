package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aeronave {

    @Id
    private String prefixo;

    private float velocidadeCruzeiro;

    public Aeronave() {
    }

    public Aeronave(String prefixo, float velocidadeCruzeiro) {
        this.prefixo = prefixo;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public float getVelocidadeCruzeiro() {
        return velocidadeCruzeiro;
    }

}
