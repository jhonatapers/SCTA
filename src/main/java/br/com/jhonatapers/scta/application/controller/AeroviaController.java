package br.com.jhonatapers.scta.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<SlotHorario> verificar(@RequestBody ConsultaSlotsLivresDto consultaSlotsLivresDto) {
        return aeroviaService.slotsLivres(consultaSlotsLivresDto.getAerovia(),
                consultaSlotsLivresDto.getDataHoraPartida(), consultaSlotsLivresDto.getVelocidadeCruzeiro());
    }

}
