package br.com.zup.edu.nossositedeviagens.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidadorCampoUnico implements ConstraintValidator<CampoUnico, Object> {

    private String atributo;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(CampoUnico constraintAnnotation) {
        this.atributo = constraintAnnotation.fieldName();
        this.klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + klass.getName() + " WHERE " + atributo + " = :value");
        query.setParameter("value", value);
        List<?> lista = query.getResultList();
        return lista.isEmpty();
    }
}

