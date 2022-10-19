package br.com.jhonatapers.scta.adapter.controller;

import br.com.jhonatapers.scta.application.usecases.CadastraPlanoDeVooUC;
import br.com.jhonatapers.scta.application.usecases.CancelarPlanoDeVooUC;
import br.com.jhonatapers.scta.application.usecases.VerificarPlanoDeVooUC;
import br.com.jhonatapers.scta.domain.dto.PlanoDeVooDto;
import br.com.jhonatapers.scta.domain.dto.ValidacaoPlanoDeVooDto;
import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planos-de-voo")
@CrossOrigin(origins = "*")
public class PlanosDeVooController {

    private CadastraPlanoDeVooUC cadastraPlanoDeVooUC;

    private CancelarPlanoDeVooUC cancelarPlanoDeVooUC;

    private VerificarPlanoDeVooUC verificarPlanoDeVooUC;

    @Autowired
    public PlanosDeVooController(CadastraPlanoDeVooUC cadastraPlanoDeVooUC, CancelarPlanoDeVooUC cancelarPlanoDeVooUC,
            VerificarPlanoDeVooUC verificarPlanoDeVooUC) {
        this.cadastraPlanoDeVooUC = cadastraPlanoDeVooUC;
        this.cancelarPlanoDeVooUC = cancelarPlanoDeVooUC;
        this.verificarPlanoDeVooUC = verificarPlanoDeVooUC;
    }

    @PostMapping("/verificar")
    public ValidacaoPlanoDeVooDto verificar(@RequestBody PlanoDeVooDto planoDeVoo) {
        return verificarPlanoDeVooUC.run(planoDeVoo);
    }

    @PostMapping
    public PlanoDeVoo cadastrar(@RequestBody PlanoDeVooDto planoDeVoo) {
        return cadastraPlanoDeVooUC.run(planoDeVoo);
    }

    @DeleteMapping("/{idPlanoDeVoo}")
    public void concelar(@PathVariable Long idPlanoDeVoo) {
        cancelarPlanoDeVooUC.run(idPlanoDeVoo);
    }

}
