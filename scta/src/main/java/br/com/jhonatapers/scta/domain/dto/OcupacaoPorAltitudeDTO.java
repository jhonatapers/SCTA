package br.com.jhonatapers.scta.domain.dto;

import br.com.jhonatapers.scta.domain.entity.SlotHorario;

import java.util.List;

public record OcupacaoPorAltitudeDTO(float altitude, float porcentagemOcupacao) {
    private static final int HORAS_NO_DIA = 24;

    public static OcupacaoPorAltitudeDTO from(float altitude, List<SlotHorario> slots) {
        return new OcupacaoPorAltitudeDTO(altitude, calculaPorcentagem(slots));
    }

    private static float calculaPorcentagem(List<SlotHorario> slots) {
        return (float) slots.size() / HORAS_NO_DIA;
    }
}
