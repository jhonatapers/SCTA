package br.com.jhonatapers.scta.domain.aggregate;

import java.time.LocalDateTime;

public class SlotHorario {
    
    private long altitude;

    private LocalDateTime dataHora;

    private boolean ocupado;

    public SlotHorario(long altitude, LocalDateTime dataHora, boolean ocupado) {
        this.altitude = altitude;
        this.dataHora = dataHora;
        this.ocupado = ocupado;
    }

    public long getAltitude() {
        return altitude;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
}
