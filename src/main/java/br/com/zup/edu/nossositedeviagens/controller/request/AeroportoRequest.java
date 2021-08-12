package br.com.zup.edu.nossositedeviagens.controller.request;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import br.com.zup.edu.nossositedeviagens.validation.CampoUnico;
import br.com.zup.edu.nossositedeviagens.validation.IdValid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AeroportoRequest {

    @NotBlank
    @CampoUnico(domainClass = Aeroporto.class, fieldName = "nome")
    private String nome;

    @NotNull
    @IdValid(domainClass = Pais.class, fieldName = "id")
    private Long idPais;

    public AeroportoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Aeroporto toAeroporto(PaisRepository paisRepository) {
        Pais pais = paisRepository.getById(idPais);
        return new Aeroporto(this.nome, pais);
    }
}
