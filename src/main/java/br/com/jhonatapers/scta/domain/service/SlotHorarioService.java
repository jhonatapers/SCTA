package br.com.jhonatapers.scta.domain.service;

import br.com.jhonatapers.scta.domain.entity.SlotHorario;
import br.com.jhonatapers.scta.domain.repository.ISlotHorarioRepository;

public class SlotHorarioService {
    private final ISlotHorarioRepository repository;

    public SlotHorarioService(ISlotHorarioRepository repository) {
        this.repository = repository;
    }

    public SlotHorario cadastrar(SlotHorario slotHorario) {
        return repository.save(slotHorario);
    }
}
