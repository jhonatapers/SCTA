package br.pucrs.projarc.flightplan.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class PlanoDeVoo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private LocalDateTime dataHora;

    private String codigoAeroportuarioOrigem;

    private String codigoAeroportuarioDestino;

    private Integer rotaId;

    private float altitude;

    private float velocidadeCruzeiro;

    private boolean cancelado;

    public PlanoDeVoo() {
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

    public String getCodigoAeroportuarioOrigem() {
        return codigoAeroportuarioOrigem;
    }

    public String getCodigoAeroportuarioDestino() {
        return codigoAeroportuarioDestino;
    }

    public Integer getRotaId() {
        return rotaId;
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
