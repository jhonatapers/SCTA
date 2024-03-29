package br.com.jhonatapers.scta.application.controller;

import br.com.jhonatapers.scta.domain.dto.ValidacaoPlanoDeVooDto;
import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import br.com.jhonatapers.scta.domain.service.PlanoDeVooService;
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
public class PlanosDeVooController {

    private final PlanoDeVooService planoDeVooService;

    @Autowired
    public PlanosDeVooController(PlanoDeVooService planoDeVooService) {
        this.planoDeVooService = planoDeVooService;
    }

    @PostMapping("/verificar")
    @CrossOrigin(origins = "*")
    public ValidacaoPlanoDeVooDto verificar(@RequestBody PlanoDeVoo planoDeVoo) {
        return planoDeVooService.verificar(planoDeVoo);
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public PlanoDeVoo cadastrar(@RequestBody PlanoDeVoo planoDeVoo) {
        return planoDeVooService.cadastrar(planoDeVoo);
    }

    @DeleteMapping("/{idPlanoDeVoo}")
    @CrossOrigin(origins = "*")
    public void concelar(@PathVariable Long idPlanoDeVoo) {
        planoDeVooService.cancelar(idPlanoDeVoo);
    }

}
