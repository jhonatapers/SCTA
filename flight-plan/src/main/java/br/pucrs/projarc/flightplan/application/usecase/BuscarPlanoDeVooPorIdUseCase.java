package br.pucrs.projarc.flightplan.application.usecase;

import br.pucrs.projarc.flightplan.domain.entity.PlanoDeVoo;
import br.pucrs.projarc.flightplan.domain.service.PlanoDeVooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscarPlanoDeVooPorIdUseCase {

    private final PlanoDeVooService service;

    @Autowired
    public BuscarPlanoDeVooPorIdUseCase(PlanoDeVooService service) {
        this.service = service;
    }

    public PlanoDeVoo execute(long id) {
        return service.buscarPorId(id);
    }
}
