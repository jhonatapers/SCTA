package br.com.jhonatapers.scta.application.usecases;

import org.springframework.stereotype.Component;

@Component
public class CadastraPlanoDeVooUC {
    private final PlanoDeVooService planoDeVooService;

    @Autowired
    public CadastraPlanoDeVooUC(PlanoDeVooService planoDeVooService){
        this.planoDeVooService = planoDeVooService;
    }

    public PlanoDeVoo run(@RequestBody PlanoDeVoo planoDeVoo){
        return planoDeVooService.cadastrar(planoDeVoo);
    }
}
