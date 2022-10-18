package br.com.jhonatapers.scta.application.usecases;

import org.springframework.stereotype.Component;

@Component
public class VerificarPlanoDeVooUC {

    private final PlanoDeVooService planoDeVooService;

    @Autowired
    public VerificarPlanoDeVooUC(PlanoDeVooService planoDeVooService){
        this.planoDeVooService = planoDeVooService;
    }

    public PlanoDeVoo run(@RequestBody PlanoDeVoo planoDeVoo){
        return planoDeVooService.verificar(planoDeVoo);
    }
    
}
