package br.com.jhonatapers.scta.application.dto;

import java.util.List;

import br.com.jhonatapers.scta.domain.dto.OcupacaoPorAltitudeDTO;

public record RelatorioDTO(List<OcupacaoPorAltitudeDTO> ocupacoes) {

}
