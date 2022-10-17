package br.com.jhonatapers.scta.domain.dto;

import java.util.List;

public class RelatorioDTO {

    private final List<OcupacaoPorAltitudeDTO> ocupacoes;

    public RelatorioDTO(List<OcupacaoPorAltitudeDTO> ocupacoes) {
        this.ocupacoes = ocupacoes;
    }

    public List<OcupacaoPorAltitudeDTO> getOcupacoes() {
        return ocupacoes;
    }
}
