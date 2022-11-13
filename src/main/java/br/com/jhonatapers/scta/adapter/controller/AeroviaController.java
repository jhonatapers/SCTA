package br.com.jhonatapers.scta.adapter.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.jhonatapers.scta.application.dto.RelatorioDTO;
import br.com.jhonatapers.scta.application.usecases.ConsultaSlotsLivreUC;
import br.com.jhonatapers.scta.application.usecases.GeraRelatorioOcupacaoUC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhonatapers.scta.domain.entity.SlotHorario;

@RestController
@RequestMapping("/aerovias")
@CrossOrigin(origins = "*")
public class AeroviaController {

    private final GeraRelatorioOcupacaoUC gerarRelatorioOcupacaoUC;

    private final ConsultaSlotsLivreUC consultaSlotsLivreUC;

    @Autowired
    public AeroviaController(GeraRelatorioOcupacaoUC gerarRelatorioOcupacaoUC,
            ConsultaSlotsLivreUC consultaSlotsLivreUC) {
        this.gerarRelatorioOcupacaoUC = gerarRelatorioOcupacaoUC;
        this.consultaSlotsLivreUC = consultaSlotsLivreUC;
    }

    @GetMapping("/slots-livres/{aeroviaId}")
    public List<SlotHorario> verificar(@PathVariable String aeroviaId,

            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraPartida,
            @RequestParam float velocidadeCruzeiro) {

        return consultaSlotsLivreUC.run(aeroviaId, dataHoraPartida, velocidadeCruzeiro);

    }

    @GetMapping("/ocupacao/{nome}")
    public RelatorioDTO gerarRelatorioOcupacao(@PathVariable String nome,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {

        return gerarRelatorioOcupacaoUC.run(nome, data);

    }

}
