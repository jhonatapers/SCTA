package br.com.jhonatapers.scta.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import br.com.jhonatapers.scta.domain.dto.OcupacaoPorAltitudeDTO;
import br.com.jhonatapers.scta.domain.entity.Aerovia;
import br.com.jhonatapers.scta.domain.entity.ReferenciaGeografica;
import br.com.jhonatapers.scta.domain.entity.SlotHorario;
import br.com.jhonatapers.scta.domain.repository.IAeroviaRepository;

import static java.util.stream.Collectors.groupingBy;

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

        return problemas(new ArrayList<String>(), origem, dataHoraPartida, altitude, velocidadeCruzeiro, aerovias,
                aerovias.size());
    }

    private List<String> problemas(List<String> problemas, ReferenciaGeografica partida, LocalDateTime dataHoraPartida,
            float altitude,
            float velocidadeCruzeiro, List<Aerovia> aerovias, final int nivel) {

        if (nivel == 0) {
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
                        || (slotHorario.getDataHora().isBefore(dataHoraFinalVoo)
                                && slotHorario.getDataHora().isAfter(dataHoraPartida)))
                .toList();
    }

    public List<SlotHorario> slotsLivres(Aerovia aerovia, LocalDateTime dataHoraPartida, float velocidadeCruzeiro) {

        List<SlotHorario> ocupados = slotsOcupados(buscar(aerovia.getNome()), dataHoraPartida, velocidadeCruzeiro);

        List<SlotHorario> desocupados = new ArrayList<>();

        int horasVoo = (int) Math.ceil(horasVoo(aerovia.getExtensao(), velocidadeCruzeiro));

        for (int i = 0; i < horasVoo; i++) {

            LocalDateTime horaAux = dataHoraPartida.plusHours(i);

            for (int j = 25; j < 35; j++) {

                desocupados.add(new SlotHorario(j * 1000, horaAux));
            }

        }

        for (SlotHorario ocupado : ocupados) {
            desocupados.removeIf(
                    d -> d.getAltitude() == ocupado.getAltitude() && d.getDataHora().isEqual(ocupado.getDataHora()));
        }

        return desocupados;

    }

    public void ocupaSlotHorario(List<Aerovia> aerovias, LocalDateTime dataHora, float altitude,
            float velocidadeCruzeiro) {

        for (Aerovia aerovia : aerovias) {

            final int horasVoo = (int) Math.ceil(horasVoo(aerovia.getExtensao(), velocidadeCruzeiro));

            for (int i = 0; i < horasVoo; i++) {
                aerovia.getSlotsHorarios().add(
                        slotHorarioService.cadastrar(new SlotHorario(altitude, dataHora.plusHours(i)))); // verificar se
                                                                                                         // mantem
                                                                                                         // a referencia
                                                                                                         // de
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
                        .filter(slotHorario -> slotHorario.getAltitude() == altitude
                                && slotHorario.getDataHora().isEqual(dataHoraSlot))
                        .toList();

                // verificar se mantem a referencia de memoria
                aerovia.getSlotsHorarios().removeAll(slotsARemover);
            }

            repository.update(aerovia);
        }
    }

    public List<OcupacaoPorAltitudeDTO> ocupacaoPorData(String nomeAerovia, LocalDate data) {
        final List<SlotHorario> slotsAerovia = buscar(nomeAerovia).getSlotsHorarios();
        return slotsAerovia.stream()
                .filter(slotHorario -> slotHorario.getDataHora().toLocalDate().isEqual(data))
                .collect(groupingBy(SlotHorario::getAltitude))
                .entrySet()
                .stream()
                .map(entry -> OcupacaoPorAltitudeDTO.from(entry.getKey(), entry.getValue()))
                .toList();
    }

    private float horasVoo(float extensaoAerovia, float velocidadeCruzeiro) {
        return extensaoAerovia / velocidadeCruzeiro;
    }

}
