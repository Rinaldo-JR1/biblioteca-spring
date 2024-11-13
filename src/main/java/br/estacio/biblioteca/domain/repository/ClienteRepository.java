package br.estacio.biblioteca.domain.repository;

import br.estacio.biblioteca.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
