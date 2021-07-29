package br.com.zup.edu.nossositedeviagens.controller.request;

import br.com.zup.edu.nossositedeviagens.model.Pais;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaisRequest {

    @JsonProperty
   // @UniqueValue(entidade = Pais.class, atributo = "nome")
    private String nome;


    public Pais toPais(){
        return new Pais(this.nome);
    }
}
