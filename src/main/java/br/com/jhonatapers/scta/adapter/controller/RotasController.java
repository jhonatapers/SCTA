package br.com.jhonatapers.scta.application.controller;

import br.com.jhonatapers.scta.domain.entity.Rota;
import br.com.jhonatapers.scta.domain.service.RotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rotas")
public class RotasController {

    private final RotasService service;

    @Autowired
    public RotasController(RotasService service) {
        this.service = service;
    }

    @GetMapping("/{codigoAeroportuario}/{codigoAeroportuario2}")
    @CrossOrigin(origins = "*")
    public List<Rota> consultar(@PathVariable String codigoAeroportuario, @PathVariable String codigoAeroportuario2) {
        return service.consultarEntreAeroportos(codigoAeroportuario, codigoAeroportuario2);
    }
}
