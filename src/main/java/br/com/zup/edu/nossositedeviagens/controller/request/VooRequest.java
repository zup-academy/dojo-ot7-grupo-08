package br.com.zup.edu.nossositedeviagens.controller.request;

import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.model.Voo;
import br.com.zup.edu.nossositedeviagens.repository.RotaRepository;
import br.com.zup.edu.nossositedeviagens.validation.IdValid;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class VooRequest {

    @IdValid(domainClass = Rota.class, fieldName = "id")
    Long idRota;

    @Positive @NotNull
    Integer numeroDeLugares;

    @Positive
    Integer tempoDeParada;

    Voo tomodel(RotaRepository rotaRepository){

    }
}
