package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Voo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "voo")
    private List<Rota> rotas;

    private Integer numeroDeLugares;

    private Integer tempoDeParada;
}
