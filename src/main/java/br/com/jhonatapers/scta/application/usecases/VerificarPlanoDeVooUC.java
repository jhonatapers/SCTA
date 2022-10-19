package br.com.jhonatapers.scta.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jhonatapers.scta.domain.dto.PlanoDeVooDto;
import br.com.jhonatapers.scta.domain.dto.ValidacaoPlanoDeVooDto;
import br.com.jhonatapers.scta.domain.service.PlanoDeVooService;

@Component
public class VerificarPlanoDeVooUC {

    private final PlanoDeVooService planoDeVooService;

    @Autowired
    public VerificarPlanoDeVooUC(PlanoDeVooService planoDeVooService) {
        this.planoDeVooService = planoDeVooService;
    }

    public ValidacaoPlanoDeVooDto run(PlanoDeVooDto planoDeVoo) {
        return planoDeVooService.verificar(planoDeVoo);
    }

}
