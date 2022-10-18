package br.com.jhonatapers.scta.adapter.jpa;

import br.com.jhonatapers.scta.domain.entity.SlotHorario;
import org.springframework.data.repository.CrudRepository;

public interface ISlotHorarioCRUD extends CrudRepository<SlotHorario, Long> {
}
