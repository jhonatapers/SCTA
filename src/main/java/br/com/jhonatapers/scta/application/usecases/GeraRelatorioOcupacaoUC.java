package br.com.jhonatapers.scta.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.jhonatapers.scta.domain.dto.RelatorioDTO;
import br.com.jhonatapers.scta.domain.service.AeroviaService;

@Component
public class GeraRelatorioOcupacaoUC {

    private final AeroviaService aeroviaService;

    @Autowired
    public GeraRelatorioOcupacaoUC(AeroviaService aeroviaService){
        this.aeroviaService = aeroviaService;
    }

    public RelatorioDTO run(@PathVariable String nome,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data){
        return new RelatorioDTO(aeroviaService.ocupacaoPorData(nome, data));
    }
    
}
