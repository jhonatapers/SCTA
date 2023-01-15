package br.pucrs.projarc.flightplan.adapter.rabbitmq;

import br.pucrs.projarc.flightplan.application.usecase.SalvarPlanoDeVooUseCase;
import br.pucrs.projarc.flightplan.domain.entity.PlanoDeVoo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlanoDeVooReceiver {

    private final SalvarPlanoDeVooUseCase salvarPlanoDeVooUC;

    private final ObjectMapper mapper;

    @Autowired
    public PlanoDeVooReceiver(SalvarPlanoDeVooUseCase salvarPlanoDeVooUC, ObjectMapper mapper) {
        this.salvarPlanoDeVooUC = salvarPlanoDeVooUC;
        this.mapper = mapper;
    }

    public void receiveMessage(String message) {

        PlanoDeVoo planoDeVoo = null;
        try {
            planoDeVoo = mapper.readValue(message, PlanoDeVoo.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        salvarPlanoDeVooUC.salvarPlanoDeVoo(planoDeVoo);
    }
}
