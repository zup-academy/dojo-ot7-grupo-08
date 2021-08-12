package br.com.zup.edu.nossositedeviagens.validation;

import br.com.zup.edu.nossositedeviagens.controller.request.RotaRequest;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidaRotaUnicaValidator implements ConstraintValidator<RotaUnica, RotaRequest> {
    @Autowired
    private RotaRepository rotaRepository;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(RotaRequest request, ConstraintValidatorContext constraintValidatorContext) {

        Optional<Rota> optional = rotaRepository.findByOrigemIdAndDestinoId(request.getIdOrigem(),request.getIdDestino());

        return !optional.isPresent();
    }
}
