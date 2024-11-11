package br.estacio.biblioteca.repository;

import br.estacio.biblioteca.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
