package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.request.AeroportoRequest;
import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    private AeroportoRepository aerorportoRepository;
    private PaisRepository paisRepository;

    public AeroportoController(AeroportoRepository aerorportoRepository, PaisRepository paisRepository) {
        this.aerorportoRepository = aerorportoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody AeroportoRequest request) {
        Aeroporto aeroporto = aerorportoRepository.save(request.toAeroporto(paisRepository));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(aeroporto.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
