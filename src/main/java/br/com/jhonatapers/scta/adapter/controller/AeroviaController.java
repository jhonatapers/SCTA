package br.com.jhonatapers.scta.application.controller;

import java.time.LocalDate;
import java.util.List;

import br.com.jhonatapers.scta.domain.dto.RelatorioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jhonatapers.scta.application.dto.ConsultaSlotsLivresDto;
import br.com.jhonatapers.scta.domain.entity.SlotHorario;
import br.com.jhonatapers.scta.domain.service.AeroviaService;

@RestController
@RequestMapping("/aerovias")
public class AeroviaController {

    private final AeroviaService aeroviaService;

    @Autowired
    public AeroviaController(AeroviaService aeroviaService) {
        this.aeroviaService = aeroviaService;
    }

    @PostMapping("/slots-livres")
    @CrossOrigin(origins = "*")
    public List<SlotHorario> verificar(@RequestBody ConsultaSlotsLivresDto consultaSlotsLivresDto) {
        return aeroviaService.slotsLivres(consultaSlotsLivresDto.getAerovia(),
                consultaSlotsLivresDto.getDataHoraPartida(), consultaSlotsLivresDto.getVelocidadeCruzeiro());
    }

    @GetMapping("/ocupacao/{nome}")
    @CrossOrigin(origins = "*")
    public RelatorioDTO gerarRelatorioOcupacao(@PathVariable String nome,
                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return new RelatorioDTO(aeroviaService.ocupacaoPorData(nome, data));
    }

}
