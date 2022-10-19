package br.com.jhonatapers.scta.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.jhonatapers.scta.domain.entity.Rota;
import br.com.jhonatapers.scta.domain.service.RotasService;

@Component
public class ConsultaRotasEntreAeroportosUC {
    private final RotasService rotasService;

    @Autowired
    public ConsultaRotasEntreAeroportosUC(RotasService rotasService) {
        this.rotasService = rotasService;
    }

    public List<Rota> run(String codigoAeroportuario, String codigoAeroportuario2) {
        return rotasService.consultarEntreAeroportos(codigoAeroportuario, codigoAeroportuario2);
    }
}
