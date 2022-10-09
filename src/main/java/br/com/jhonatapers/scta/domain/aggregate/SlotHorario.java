package br.com.jhonatapers.scta.domain.aggregate;

import java.sql.Date;

public class SlotHorario {
    
    private long altitude;

    private Date dataHora;

    private boolean ocupado;

    public SlotHorario(long altitude, Date dataHora, boolean ocupado) {
        this.altitude = altitude;
        this.dataHora = dataHora;
        this.ocupado = ocupado;
    }

    public long getAltitude() {
        return altitude;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
}
