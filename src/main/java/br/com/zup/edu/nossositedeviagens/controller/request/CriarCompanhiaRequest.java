package br.com.zup.edu.nossositedeviagens.controller.request;

import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import br.com.zup.edu.nossositedeviagens.validation.CampoUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class CriarCompanhiaRequest {

    @NotBlank
    @CampoUnico(domainClass = Companhia.class, fieldName = "nome")
    private String nome;

    @NotNull
    private Long paisId;

    public CriarCompanhiaRequest(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Optional<Companhia> toModel(PaisRepository paisRepository) {
        Optional<Pais> paisObj = paisRepository.findById(this.paisId);
        if(paisObj.isPresent()) {
            Pais pais = paisObj.get();
            return Optional.of(new Companhia(this.nome, pais));
        }

        return Optional.empty();
    }
}
