package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.request.RotaRequest;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repository.RotaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/rotas")
public class RotasController {

    private RotaRepository rotaRepository;
    private AeroportoRepository aerorportoRepository;

    public RotasController(RotaRepository rotaRepository, AeroportoRepository aerorportoRepository) {
        this.rotaRepository = rotaRepository;
        this.aerorportoRepository = aerorportoRepository;
    }

    @PostMapping
    public ResponseEntity<?> salva(@RequestBody @Valid RotaRequest request){
        Optional<Rota> optional = request.toRota(aerorportoRepository);
        if(optional.isPresent()){
            Rota rota = optional.get();
            rotaRepository.save(rota);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(rota.getId()).toUri();

            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.badRequest().build();
    }

}
