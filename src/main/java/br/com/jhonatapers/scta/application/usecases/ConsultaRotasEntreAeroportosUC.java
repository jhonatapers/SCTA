package br.com.jhonatapers.scta.application.usecases;

import org.springframework.stereotype.Component;

@Component
public class ConsultaRotasEntreAeroportosUC {
    private final RotasService rotasService;

    @Autowired
    public ConsultaRotasEntreAeroportosUC(RotasService rotasService) {
        this.rotasService = rotasService;
    }

    public List<Rota> run(@PathVariable String codigoAeroportuario, @PathVariable String codigoAeroportuario2) {
        return rotasService.consultarEntreAeroportos(codigoAeroportuario, codigoAeroportuario2);
    }
}
