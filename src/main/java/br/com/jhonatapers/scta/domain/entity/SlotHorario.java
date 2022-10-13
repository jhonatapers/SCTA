package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class SlotHorario {

    private float altitude;

    private LocalDateTime dataHora;

    public SlotHorario(float altitude, LocalDateTime dataHora) {
        this.altitude = altitude;
        this.dataHora = dataHora;
    }

    public float getAltitude() {
        return altitude;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

}
