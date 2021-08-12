package br.com.zup.edu.nossositedeviagens.repository;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerorportoRepository extends JpaRepository<Aeroporto, Long> {
}
