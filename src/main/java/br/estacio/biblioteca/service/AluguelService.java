package br.estacio.biblioteca.service;



import br.estacio.biblioteca.model.Aluguel;

import java.util.List;
import java.util.Optional;

public interface AluguelService {

    Aluguel save(Aluguel alguel);
    List<Aluguel> findAll();
    Optional<Aluguel> findById(Long id);
    Aluguel update(Aluguel livro);
    void deleteById(Long id);

}
