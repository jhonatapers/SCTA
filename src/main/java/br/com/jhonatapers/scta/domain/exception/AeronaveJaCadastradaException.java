package br.com.jhonatapers.scta.domain.exception;

public class AeronaveJaCadastradaException extends Exception {
    
    public AeronaveJaCadastradaException(){
        super("Aeronave já cadastrada");
    }

}
