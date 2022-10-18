package br.com.jhonatapers.scta.application.dto;

import java.time.LocalDateTime;

import br.com.jhonatapers.scta.domain.entity.Aerovia;

public class ConsultaSlotsLivresDto {

    private Aerovia aerovia;

    private LocalDateTime dataHoraPartida;

    private float velocidadeCruzeiro;

    public ConsultaSlotsLivresDto(Aerovia aerovia, LocalDateTime dataHoraPartida, float velocidadeCruzeiro) {
        this.aerovia = aerovia;
        this.dataHoraPartida = dataHoraPartida;
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }

    public Aerovia getAerovia() {
        return aerovia;
    }

    public void setAerovia(Aerovia aerovia) {
        this.aerovia = aerovia;
    }

    public LocalDateTime getDataHoraPartida() {
        return dataHoraPartida;
    }

    public void setDataHoraPartida(LocalDateTime dataHoraPartida) {
        this.dataHoraPartida = dataHoraPartida;
    }

    public float getVelocidadeCruzeiro() {
        return velocidadeCruzeiro;
    }

    public void setVelocidadeCruzeiro(float velocidadeCruzeiro) {
        this.velocidadeCruzeiro = velocidadeCruzeiro;
    }
    
}
