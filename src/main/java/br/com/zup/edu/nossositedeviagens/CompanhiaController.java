package br.com.zup.edu.nossositedeviagens;

import br.com.zup.edu.nossositedeviagens.repository.CompanhiaRepository;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {


    private CompanhiaRepository repository;
    private PaisRepository paisRepository;
}
