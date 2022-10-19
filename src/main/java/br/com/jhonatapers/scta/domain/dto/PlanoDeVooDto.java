package br.com.jhonatapers.scta.domain.dto;

import java.time.LocalDateTime;

public class PlanoDeVooDto {

    private LocalDateTime dataHora;

    private String codigoAeroportuarioOrigem;

    private String codigoAeroportuarioDestino;

    private long rotaId;

    private float altitude;

    private float velocidadeCruzeiro;

    private boolean cancelado;

    public PlanoDeVooDto(LocalDateTime dataHora,
            String codigoAeroportuarioOrigem,
            String codigoAeroportuarioDestino,
            long rotaId,
            float altitude,
            float velocidadeCruzeiro,
            boolean cancelado) {
        this.dataHora = dataHora;
        this.codigoAeroportuarioOrigem = codigoAeroportuarioOrigem;
        this.codigoAeroportuarioDestino = codigoAeroportuarioDestino;
        this.rotaId = rotaId;
        this.altitude = altitude;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
        this.cancelado = cancelado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getCodigoAeroportuarioOrigem() {
        return codigoAeroportuarioOrigem;
    }

    public void setCodigoAeroportuarioOrigem(String codigoAeroportuarioOrigem) {
        this.codigoAeroportuarioOrigem = codigoAeroportuarioOrigem;
    }

    public String getCodigoAeroportuarioDestino() {
        return codigoAeroportuarioDestino;
    }

    public void setCodigoAeroportuarioDestino(String codigoAeroportuarioDestino) {
        this.codigoAeroportuarioDestino = codigoAeroportuarioDestino;
    }

    public long getRotaId() {
        return rotaId;
    }

    public void setRotaId(long rotaId) {
        this.rotaId = rotaId;
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