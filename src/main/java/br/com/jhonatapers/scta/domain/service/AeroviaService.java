package br.com.jhonatapers.scta.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.jhonatapers.scta.domain.entity.Aerovia;
import br.com.jhonatapers.scta.domain.aggregate.SlotHorario;
import br.com.jhonatapers.scta.domain.repository.IAeroviaRepository;

public class AeroviaService {

    @Autowired
    private IAeroviaRepository repository;

    public Aerovia buscar(String nome) {
        return repository.findByNome(nome);
    }

    public List<SlotHorario> slotsOcupados(Aerovia aerovia, LocalDateTime dataHoraPartida, float velocidadeCruzeiro) {
        final int horasVoo = (int) Math.ceil(horasVoo(aerovia.getExtensao(), velocidadeCruzeiro));
        final LocalDateTime dataHoraFinalVoo = dataHoraPartida.plusHours(horasVoo);

        return aerovia.getSlotsHorarios()
                .stream()
                .filter(slotHorario -> {
                    return slotHorario.getDataHora().isBefore(dataHoraPartida)
                            && slotHorario.getDataHora().isAfter(dataHoraFinalVoo);
                })
                .toList();
    }

    public void ocupaSlotHorario(List<Aerovia> aerovias, LocalDateTime dataHora, float altitude,
            float velocidadeCruzeiro) {

        for (Aerovia aerovia : aerovias) {

            final int horasVoo = (int) Math.ceil(horasVoo(aerovia.getExtensao(), velocidadeCruzeiro));

            for (int i = 0; i < horasVoo; i++) {
                aerovia.getSlotsHorarios().add(new SlotHorario(altitude, dataHora.plusHours(i))); // verificar se mantem
                                                                                                  // a referencia de
                                                                                                  // memoria
            }

            repository.update(aerovia);
        }
    }

    public void desocupaSlotHorario(List<Aerovia> aerovias, LocalDateTime dataHora, float altitude,
            float velocidadeCruzeiro) {
        for (Aerovia aerovia : aerovias) {

            final int horasVoo = (int) Math.ceil(horasVoo(aerovia.getExtensao(), velocidadeCruzeiro));

            for (int i = 0; i < horasVoo; i++) {

                final LocalDateTime dataHoraSlot = dataHora.plusHours(i);

                List<SlotHorario> slotsARemover = aerovia.getSlotsHorarios()
                        .stream()
                        .filter(slotHorario -> {
                            return slotHorario.getAltitude() == altitude
                                    && slotHorario.getDataHora().isEqual(dataHoraSlot);
                        })
                        .toList();

                // verificar se mantem a referencia de memoria
                aerovia.getSlotsHorarios().removeAll(slotsARemover);
            }

            repository.update(aerovia);
        }
    }

    public List<SlotHorario> ocupacaoPorData(LocalDate data) {
        List<SlotHorario> ocupacao = new ArrayList<SlotHorario>();

        // deixar no dominio? ou trazer todas para aplicacao filtrar?

        return ocupacao;
    }

    private float horasVoo(float extensaoAerovia, float velocidadeCruzeiro) {
        return extensaoAerovia / velocidadeCruzeiro;
    }

}