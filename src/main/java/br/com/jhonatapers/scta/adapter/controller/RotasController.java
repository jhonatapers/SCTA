package br.com.jhonatapers.scta.adapter.controller;

import br.com.jhonatapers.scta.application.usecases.ConsultaRotasEntreAeroportosUC;
import br.com.jhonatapers.scta.domain.entity.Rota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rotas")
@CrossOrigin(origins = "*")
public class RotasController {

    private final ConsultaRotasEntreAeroportosUC consultaRotasEntreAeroportosUC;

    @Autowired
    public RotasController(ConsultaRotasEntreAeroportosUC consultaRotasEntreAeroportosUC) {
        this.consultaRotasEntreAeroportosUC = consultaRotasEntreAeroportosUC;
    }

    @GetMapping("/{codigoAeroportuario}/{codigoAeroportuario2}")
    public List<Rota> consultar(@PathVariable String codigoAeroportuario, @PathVariable String codigoAeroportuario2) {
        return consultaRotasEntreAeroportosUC.run(codigoAeroportuario, codigoAeroportuario2);
    }
}
