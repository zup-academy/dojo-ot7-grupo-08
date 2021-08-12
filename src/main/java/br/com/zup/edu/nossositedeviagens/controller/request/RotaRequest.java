package br.com.zup.edu.nossositedeviagens.controller.request;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.validation.RotaUnica;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

@RotaUnica
public class RotaRequest {

    private String nome;
    @NotNull
    private Long idOrigem;
    @NotNull
    private Long idDestino;
    @NotNull
    @Positive
    private Integer duracao;

    public RotaRequest(String nome, Long idOrigem, Long idDestino, Integer duracao) {
        this.nome = nome;
        this.idOrigem = idOrigem;
        this.idDestino = idDestino;
        this.duracao = duracao;
    }

    public Optional<Rota> toRota(AeroportoRepository aeroportoRepository){
        if(idOrigem != idDestino){
            Aeroporto aeroOrigem = aeroportoRepository.getById(idOrigem);
            Aeroporto aeroDestino = aeroportoRepository.getById(idDestino);

            if(nome == null){
                nome = aeroOrigem.getNome() + aeroDestino.getNome();
            }

            return Optional.of(new Rota(this.nome, aeroOrigem, aeroDestino, this.duracao));
        }

        return Optional.empty();
    }

    public Long getIdOrigem() {
        return idOrigem;
    }

    public Long getIdDestino() {
        return idDestino;
    }
}
