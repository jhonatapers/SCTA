package br.pucrs.projarc.flightplan.domain.service;

import br.pucrs.projarc.flightplan.domain.entity.PlanoDeVoo;
import br.pucrs.projarc.flightplan.domain.repository.IPlanoDeVooRepository;

public class PlanoDeVooService {

    private final IPlanoDeVooRepository planoDeVooRepository;

    public PlanoDeVooService(IPlanoDeVooRepository planoDeVooRepository) {
        this.planoDeVooRepository = planoDeVooRepository;
    }

    public void cancelar(final long id) {
        final var planoDeVoo = buscarPorId(id);
        planoDeVoo.setCancelado(true);

        planoDeVooRepository.save(planoDeVoo);
    }

    public PlanoDeVoo buscarPorId(long id) {
        return planoDeVooRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plano de voo não encontrado"));
    }

    public PlanoDeVoo salvar(final PlanoDeVoo planoDeVoo) {
        return planoDeVooRepository.save(planoDeVoo);
    }
}
