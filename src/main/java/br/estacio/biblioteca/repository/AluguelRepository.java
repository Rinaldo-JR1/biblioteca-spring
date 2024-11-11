package br.estacio.biblioteca.repository;

import br.estacio.biblioteca.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel,Long> {
}
