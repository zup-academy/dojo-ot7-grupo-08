package br.com.zup.edu.nossositedeviagens.repository;

import br.com.zup.edu.nossositedeviagens.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long> {
}
