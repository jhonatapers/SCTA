package br.com.jhonatapers.scta.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jhonatapers.scta.domain.service.PlanoDeVooService;

@Component
public class CancelarPlanoDeVooUC {

    private final PlanoDeVooService planoDeVooService;

    @Autowired
    public CancelarPlanoDeVooUC(PlanoDeVooService planoDeVooService) {
        this.planoDeVooService = planoDeVooService;
    }

    public void run(Long idPlanoDeVoo) {
        planoDeVooService.cancelar(idPlanoDeVoo);
    }

}
