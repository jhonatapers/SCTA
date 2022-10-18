package br.com.jhonatapers.scta.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlanoDeVoo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private LocalDateTime dataHora;

    @ManyToOne
    private Aeroporto aeroportoOrigem;

    @ManyToOne
    private Aeroporto aeroportoDestino;

    @ManyToOne
    private Rota rota;

    private float altitude;

    private float velocidadeCruzeiro;

    private boolean cancelado;

    public PlanoDeVoo() {
    }

    public PlanoDeVoo(LocalDateTime data, Rota rota, float altitude, float velocidadeCruzeiro) {
        this.dataHora = data;
        this.rota = rota;
        this.altitude = altitude;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime data) {
        this.dataHora = data;
    }

    public Aeroporto getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public void setAeroportoOrigem(Aeroporto aeroportoOrigem) {
        this.aeroportoOrigem = aeroportoOrigem;
    }

    public Aeroporto getAeroportoDestino() {
        return aeroportoDestino;
    }

    public void setAeroportoDestino(Aeroporto aeroportoDestino) {
        this.aeroportoDestino = aeroportoDestino;
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
