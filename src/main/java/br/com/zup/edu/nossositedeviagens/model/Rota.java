package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;

@Entity
public class Rota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Aeroporto origem;
    @ManyToOne
    private Aeroporto destino;
    private Integer duracao;

    @ManyToOne
    private Voo voo;

    public Rota(String nome, Aeroporto origem, Aeroporto destino, Integer duracao) {
        this.nome = nome;
        this.origem = origem;
        this.destino = destino;
        this.duracao = duracao;
    }

    public Rota() {
    }

    public Long getId() {
        return id;
    }
}
