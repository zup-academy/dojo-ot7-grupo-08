package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String nome;

    public Pais() {}

    public Pais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
}
