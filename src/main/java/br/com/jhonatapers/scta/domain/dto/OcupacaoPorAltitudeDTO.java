package br.com.jhonatapers.scta.domain.dto;

import br.com.jhonatapers.scta.domain.entity.SlotHorario;

import java.util.List;

public class OcupacaoPorAltitudeDTO {
    private static final int HORAS_NO_DIA = 24;
    private final float altitude;
    private final float porcentagemOcupacao;

    public OcupacaoPorAltitudeDTO(float altitude, float porcentagemOcupacao) {
        this.altitude = altitude;
        this.porcentagemOcupacao = porcentagemOcupacao;
    }

    public static OcupacaoPorAltitudeDTO from(float altitude, List<SlotHorario> slots) {
        return new OcupacaoPorAltitudeDTO(altitude, calculaPorcentagem(slots));
    }

    private static float calculaPorcentagem(List<SlotHorario> slots) {
        return (float) slots.size() / HORAS_NO_DIA;
    }

    public float getAltitude() {
        return altitude;
    }

    public float getPorcentagemOcupacao() {
        return porcentagemOcupacao;
    }
}
