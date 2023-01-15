package br.pucrs.projarc.flightplan.application.usecase;

import br.pucrs.projarc.flightplan.domain.service.PlanoDeVooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CancelarPlanoDeVooUseCase {

    private final PlanoDeVooService service;

    @Autowired
    public CancelarPlanoDeVooUseCase(PlanoDeVooService service) {
        this.service = service;
    }

    public void execute(long id) {
        service.cancelar(id);
    }
}
