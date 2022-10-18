package br.com.jhonatapers.scta.adapter.repository;

import br.com.jhonatapers.scta.adapter.jpa.ISlotHorarioCRUD;
import br.com.jhonatapers.scta.domain.entity.SlotHorario;
import br.com.jhonatapers.scta.domain.repository.ISlotHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ISlotHorarioRepositoryImpl implements ISlotHorarioRepository {

    private final ISlotHorarioCRUD slotHorarioCRUD;

    @Autowired
    public ISlotHorarioRepositoryImpl(ISlotHorarioCRUD slotHorarioCRUD) {
        this.slotHorarioCRUD = slotHorarioCRUD;
    }

    @Override
    public SlotHorario save(SlotHorario slotHorario) {
        return slotHorarioCRUD.save(slotHorario);
    }
}
