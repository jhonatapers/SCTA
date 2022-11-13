package br.com.jhonatapers.scta.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidacaoPlanoDeVooDto {

    private boolean isValid;
    private List<String> problemas;

    public ValidacaoPlanoDeVooDto() {
        this.isValid = true;
        this.problemas = new ArrayList<>();
    }

    public void addProblema(String problema) {
        isValid = false;
        problemas.add(problema);
    }

    public void setProblemas(List<String> problemas) {
        isValid = problemas.isEmpty();
        this.problemas = problemas;
    }

    public boolean isValid() {
        return isValid;
    }

    public List<String> getProblemas() {
        return problemas;
    }
}
