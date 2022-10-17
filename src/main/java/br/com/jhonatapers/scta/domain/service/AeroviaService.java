package br.com.jhonatapers.scta.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import br.com.jhonatapers.scta.domain.entity.Aerovia;
import br.com.jhonatapers.scta.domain.entity.ReferenciaGeografica;
import br.com.jhonatapers.scta.domain.entity.SlotHorario;
import br.com.jhonatapers.scta.domain.repository.IAeroviaRepository;

public class AeroviaService {

    private final IAeroviaRepository repository;
    private final SlotHorarioService slotHorarioService;

    public AeroviaService(IAeroviaRepository repository, SlotHorarioService slotHorarioService) {
        this.repository = repository;
        this.slotHorarioService = slotHorarioService;
    }

    public Aerovia buscar(String nome) {
        return repository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Aerovia não encontrada"));
    }

    public List<String> validacao(List<Aerovia> aerovias, ReferenciaGeografica origem, LocalDateTime dataHoraPartida,
            float altitude,
            float velocidadeCruzeiro) {

        return problemas(new ArrayList<String>(), origem, dataHoraPartida, altitude, velocidadeCruzeiro, aerovias, aerovias.size());
    }

    private List<String> problemas(List<String> problemas, ReferenciaGeografica partida, LocalDateTime dataHoraPartida,
            float altitude,
            float velocidadeCruzeiro, List<Aerovia> aerovias, final int nivel) {

        if (nivel == 0 ) {
            return problemas;
        }

        aerovias.stream()
                .filter(aerovia -> aerovia.getExtremoFinal().equals(partida)
                        || aerovia.getExtremoInicio().equals(partida))
                .findFirst()
                .ifPresent(aerovia -> {

                    aerovia = repository.findByNome(aerovia.getNome()).get();

                    if (!slotsOcupados(aerovia, dataHoraPartida, velocidadeCruzeiro).isEmpty())
                        problemas.add("Aerovia " + aerovia.getNome() + " ocupada.");

                    if (aerovia.getExtremoFinal().equals(partida)) {
                        List<String> list = problemas(problemas, aerovia.getExtremoInicio(),
                                dataHoraPartida.plusHours(
                                        (long) Math.ceil(horasVoo(aerovia.getExtensao(), velocidadeCruzeiro))),
                                altitude,
                                velocidadeCruzeiro, aerovias, nivel - 1);
                        problemas.addAll(list);

                    } else {
                        List<String> list = problemas(problemas, aerovia.getExtremoFinal(), dataHoraPartida, altitude,
                                velocidadeCruzeiro, aerovias, nivel - 1);
                        problemas.addAll(list);
                    }
                });

        return problemas.stream().distinct().toList();
    }

    public List<SlotHorario> slotsOcupados(Aerovia aerovia, LocalDateTime dataHoraPartida, float velocidadeCruzeiro) {
        final int horasVoo = (int) Math.ceil(horasVoo(aerovia.getExtensao(), velocidadeCruzeiro));
        final LocalDateTime dataHoraFinalVoo = dataHoraPartida.plusHours(horasVoo);

        return aerovia.getSlotsHorarios()
                .stream()
                .filter(slotHorario -> slotHorario.getDataHora().isEqual(dataHoraPartida.truncatedTo(ChronoUnit.HOURS))
                        || (slotHorario.getDataHora().isBefore(dataHoraFinalVoo) && slotHorario.getDataHora().isAfter(dataHoraPartida)))
                .toList();
    }

    public void ocupaSlotHorario(List<Aerovia> aerovias, LocalDateTime dataHora, float altitude,
            float velocidadeCruzeiro) {

        for (Aerovia aerovia : aerovias) {

            final int horasVoo = (int) Math.ceil(horasVoo(aerovia.getExtensao(), velocidadeCruzeiro));

            for (int i = 0; i < horasVoo; i++) {
                aerovia.getSlotsHorarios().add(
                        slotHorarioService.cadastrar(new SlotHorario(altitude, dataHora.plusHours(i)))
                ); // verificar se mantem
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
