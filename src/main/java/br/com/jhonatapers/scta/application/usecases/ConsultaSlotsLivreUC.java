package br.com.jhonatapers.scta.application.usecases;

import org.springframework.stereotype.Component;

@Component
public class ConsultaSlotsLivreUC {

    private final AeroviaService aeroviaService;

    @Autowired
    public ConsultaSlotsLivreUC(AeroviaService aeroviaService){
        this.aeroviaService = aeroviaService;
    }

    public List<SlotHorario> run(@RequestBody ConsultaSlotsLivresDto consultaSlotsLivresDto){
        aeroviaService.slotsLivres(consultaSlotsLivresDto.getAerovia(),
        consultaSlotsLivresDto.getDataHoraPartida(), consultaSlotsLivresDto.getVelocidadeCruzeiro())
    }
}
