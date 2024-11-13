package br.estacio.biblioteca.domain.repository;

import br.estacio.biblioteca.domain.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,Long> {
}
