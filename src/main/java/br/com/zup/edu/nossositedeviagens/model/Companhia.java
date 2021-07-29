package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Companhia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;
    private LocalDateTime dataCriacao;

    @ManyToOne
    private Pais pais;

    public Companhia(String nome, Pais pais) {
        this.nome = nome;
        this.dataCriacao = LocalDateTime.now();
        this.pais = pais;
    }

    public Long getId() {
        return id;
    }
}
