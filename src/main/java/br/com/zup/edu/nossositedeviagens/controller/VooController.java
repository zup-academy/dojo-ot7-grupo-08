package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.repository.RotaRepository;
import br.com.zup.edu.nossositedeviagens.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VooController {

    @Autowired
    private VooRepository vooRepository;

    @Autowired
    private RotaRepository rotaRepository
}
