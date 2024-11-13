package br.estacio.biblioteca.application.service;

import br.estacio.biblioteca.domain.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Cliente update(Cliente cliente);
    void deleteById(Long id);
}
