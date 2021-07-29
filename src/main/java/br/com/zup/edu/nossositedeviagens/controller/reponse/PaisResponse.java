package br.com.zup.edu.nossositedeviagens.controller.reponse;

import br.com.zup.edu.nossositedeviagens.model.Pais;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaisResponse {

    @JsonProperty
    private Long id;

    @JsonCreator
    public PaisResponse (Pais pais){
        this.id = pais.getId();
    }

    public Long getId() {
        return id;
    }
}
