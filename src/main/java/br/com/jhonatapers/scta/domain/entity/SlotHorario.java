package br.com.jhonatapers.scta.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class SlotHorario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private float altitude;

    private LocalDateTime dataHora;

    public SlotHorario() {
    }

    public SlotHorario(float altitude, LocalDateTime dataHora) {
        this.altitude = altitude;
        this.dataHora = dataHora;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getAltitude() {
        return altitude;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

}
