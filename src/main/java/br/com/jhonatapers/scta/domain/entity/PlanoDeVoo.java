package br.com.jhonatapers.scta.domain.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlanoDeVoo {

    @Id
    private long id;

    private Date data;

    private Rota rota;

    private float altitude;

    private float velocidadeCruzeiro;

    private boolean cancelado;

    public PlanoDeVoo(Date data, Rota rota, float altitude, float velocidadeCruzeiro) {
        this.data = data;
        this.rota = rota;
        this.altitude = altitude;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    public long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getVelocidadeCruzeiro() {
        return velocidadeCruzeiro;
    }

    public void setVelocidadeCruzeiro(float velocidadeCruzeiro) {
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

}
