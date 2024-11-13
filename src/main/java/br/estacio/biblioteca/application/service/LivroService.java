package br.estacio.biblioteca.application.service;

import br.estacio.biblioteca.domain.entities.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroService {
    Livro save(Livro livro);
    List<Livro> findAll();
    Optional<Livro> findById(Long id);
    Livro update(Livro livro);
    void deleteById(Long id);
}
