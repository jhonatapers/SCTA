package br.com.jhonatapers.scta.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jhonatapers.scta.domain.dto.PlanoDeVooDto;
import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import br.com.jhonatapers.scta.domain.service.PlanoDeVooService;

@Component
public class CadastraPlanoDeVooUC {
    private final PlanoDeVooService planoDeVooService;

    @Autowired
    public CadastraPlanoDeVooUC(PlanoDeVooService planoDeVooService) {
        this.planoDeVooService = planoDeVooService;
    }

    public PlanoDeVoo run(PlanoDeVooDto planoDeVoo) {
        return planoDeVooService.cadastrar(planoDeVoo);
    }
}
