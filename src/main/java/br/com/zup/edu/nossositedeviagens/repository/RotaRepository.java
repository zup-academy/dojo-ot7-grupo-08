package br.com.zup.edu.nossositedeviagens.repository;

import br.com.zup.edu.nossositedeviagens.model.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {

    Optional<Rota> findByOrigemIdAndDestinoId(Long idOrigem, Long idDestino);
}
