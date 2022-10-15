package br.com.jhonatapers.scta.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aerovia { // aerovia 1 // ref 1 // ref 2
                       // aerovia 2 // ref 1 // ref 3

    @Id
    private String nome;

    @ManyToOne
    private ReferenciaGeografica extremoInicio;

    @ManyToOne
    private ReferenciaGeografica extremoFinal;

    private float extensao;

    @OneToMany
    private List<SlotHorario> slotsHorarios;

    public Aerovia() {
    }

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
