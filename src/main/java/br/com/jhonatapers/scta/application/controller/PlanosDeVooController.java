package br.com.jhonatapers.scta.application.controller;

import br.com.jhonatapers.scta.domain.dto.ValidacaoPlanoDeVooDto;
import br.com.jhonatapers.scta.domain.entity.PlanoDeVoo;
import br.com.jhonatapers.scta.domain.service.PlanoDeVooService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ValidacaoPlanoDeVooDto verificar(@RequestBody PlanoDeVoo planoDeVoo) {
        return planoDeVooService.verificar(planoDeVoo);
    }

    @PostMapping
    public PlanoDeVoo cadastrar(@RequestBody PlanoDeVoo planoDeVoo) {
        return planoDeVooService.cadastrar(planoDeVoo);
    }
}
