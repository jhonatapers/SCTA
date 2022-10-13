package br.com.jhonatapers.scta.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.jhonatapers.scta.domain.aggregate.SlotHorario;

@Entity
public class Aerovia {

    @Id
    private final String nome;

    private ReferenciaGeografica extremoInicio;

    private ReferenciaGeografica extremoFinal;

    private float extensao;

    private List<SlotHorario> slotsHorarios;

    public Aerovia(String nome, ReferenciaGeografica extremoInicio, ReferenciaGeografica extremoFinal, float extensao) {
        this.nome = nome;
        this.extremoInicio = extremoInicio;
        this.extremoFinal = extremoFinal;
        this.extensao = extensao;
    }

    public String getNome() {
        return nome;
    }

    public ReferenciaGeografica getExtremoInicio() {
        return extremoInicio;
    }

    public ReferenciaGeografica getExtremoFinal() {
        return extremoFinal;
    }

    public float getExtensao() {
        return extensao;
    }

    public List<SlotHorario> getSlotsHorarios() {
        return slotsHorarios;
    }

    public void addSlotHorario(SlotHorario slotHorario) {
        this.slotsHorarios.add(slotHorario);
    }

}
