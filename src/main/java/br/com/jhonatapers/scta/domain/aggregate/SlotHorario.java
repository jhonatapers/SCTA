package br.com.jhonatapers.scta.domain.aggregate;

import java.time.LocalDateTime;

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
