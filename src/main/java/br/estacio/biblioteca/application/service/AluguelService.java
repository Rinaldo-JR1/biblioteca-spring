package br.estacio.biblioteca.application.service;



import br.estacio.biblioteca.domain.entities.Aluguel;

import java.util.List;
import java.util.Optional;

public interface AluguelService {

    Aluguel save(Aluguel aluguel);
    List<Aluguel> findAll();
    Optional<Aluguel> findById(Long id);
    Aluguel update(Aluguel livro);
    void deleteById(Long id);

    List<Aluguel> findAlugueisWithLivroByClienteId(Long clienteId);
    Aluguel criarAluguel(Long clienteId, Long livroId);
}
