package br.pucrs.projarc.flightplan.application.usecase;

import br.pucrs.projarc.flightplan.domain.entity.PlanoDeVoo;
import br.pucrs.projarc.flightplan.domain.service.PlanoDeVooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarPlanoDeVooUseCase {

    private final PlanoDeVooService service;

    @Autowired
    public SalvarPlanoDeVooUseCase(PlanoDeVooService service) {
        this.service = service;
    }

    public PlanoDeVoo salvarPlanoDeVoo(PlanoDeVoo planoDeVoo) {
        return service.salvar(planoDeVoo);
    }
}
