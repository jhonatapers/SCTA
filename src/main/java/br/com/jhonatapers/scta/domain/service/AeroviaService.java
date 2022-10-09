package br.com.jhonatapers.scta.domain.service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import br.com.jhonatapers.scta.domain.entity.Aerovia;
import br.com.jhonatapers.scta.domain.aggregate.SlotHorario;
import br.com.jhonatapers.scta.domain.repository.IAeroviaRepository;

public class AeroviaService {

    private IAeroviaRepository repository;

    public Aerovia criar(Aerovia aerovia) {
        Aerovia _aerovia = buscar(aerovia.getNome());

        if (_aerovia == null)
            return repository.save(aerovia);
        else
            return _aerovia;
    }

    public void remover(Aerovia aerovia) {
        repository.remove(aerovia);
    }

    public Aerovia buscar(String nome) {
        return repository.findByNome(nome);
    }

    public List<SlotHorario> slotsHorariosLivres(Aerovia aerovia, LocalDateTime dataHoraPartida, float velocidadeCruzeiro, boolean sentidoIda) {

        List<SlotHorario> slotsHorariosLivres = new LinkedList<SlotHorario>();

        return slotsHorariosLivres;

    }

}
