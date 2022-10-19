package br.com.jhonatapers.scta.application.usecases;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jhonatapers.scta.domain.entity.SlotHorario;
import br.com.jhonatapers.scta.domain.service.AeroviaService;

@Component
public class ConsultaSlotsLivreUC {

    private final AeroviaService aeroviaService;

    @Autowired
    public ConsultaSlotsLivreUC(AeroviaService aeroviaService) {
        this.aeroviaService = aeroviaService;
    }

    public List<SlotHorario> run(String aeroviaId, LocalDateTime dataHoraPartida,
            float velocidadeCruzeiro) {

        return aeroviaService.slotsLivres(aeroviaId, dataHoraPartida, velocidadeCruzeiro);
    }
}
