package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.request.CriarCompanhiaRequest;
import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.repository.CompanhiaRepository;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {

    private CompanhiaRepository repository;
    private PaisRepository paisRepository;

    public CompanhiaController(CompanhiaRepository repository, PaisRepository paisRepository) {
        this.repository = repository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid CriarCompanhiaRequest companhiaRequest) {
        Optional<Companhia> companhiaObj = companhiaRequest.toModel(paisRepository);
        if(companhiaObj.isPresent()) {
            Companhia companhia = companhiaObj.get();
            repository.save(companhia);
            URI uri = UriComponentsBuilder.fromPath("/companhias/{id}").buildAndExpand(companhia.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }

        return ResponseEntity.badRequest().build();
    }
}
