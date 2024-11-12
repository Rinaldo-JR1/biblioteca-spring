package br.estacio.biblioteca.repository;

import br.estacio.biblioteca.model.Cliente;
import br.estacio.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
