package br.pucrs.projarc.flightplan.adapter.controller;

import br.pucrs.projarc.flightplan.application.usecase.BuscarPlanoDeVooPorIdUseCase;
import br.pucrs.projarc.flightplan.application.usecase.CancelarPlanoDeVooUseCase;
import br.pucrs.projarc.flightplan.domain.entity.PlanoDeVoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plano-de-voo")
public class PlanoDeVooController {

    private CancelarPlanoDeVooUseCase cancelarPlanoDeVooUC;
    private BuscarPlanoDeVooPorIdUseCase buscarPorIdUC;

    @Autowired
    public PlanoDeVooController(CancelarPlanoDeVooUseCase cancelarPlanoDeVooUC, BuscarPlanoDeVooPorIdUseCase buscarPorIdUC) {
        this.cancelarPlanoDeVooUC = cancelarPlanoDeVooUC;
        this.buscarPorIdUC = buscarPorIdUC;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable long id) {
        cancelarPlanoDeVooUC.execute(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoDeVoo> buscarPorId(@PathVariable long id) {
        final PlanoDeVoo planoDeVoo = buscarPorIdUC.execute(id);

        return ResponseEntity.ok(planoDeVoo);
    }

}
