package br.com.jhonatapers.scta.application.usecases;

import org.springframework.stereotype.Component;

@Component
public class CancelarPlanoDeVooUC {

    private final PlanoDeVooService planoDeVooService;

    @Autowired
    public CancelarPlanoDeVooUC(PlanoDeVooService planoDeVooService){
        this.planoDeVooService = planoDeVooService;
    }

    public void run(@PathVariable Long idPlanoDeVoo) {
        return planoDeVooService.cancelar(planoDeVoo);
    }
    
}
