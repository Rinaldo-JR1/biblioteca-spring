package br.estacio.biblioteca.domain.repository;

import br.estacio.biblioteca.domain.entities.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AluguelRepository extends JpaRepository<Aluguel,Long> {
    @Query("SELECT a FROM Aluguel a JOIN FETCH a.livro WHERE a.cliente.id = :clienteId")
    List<Aluguel> findAlugueisWithLivroByClienteId(@Param("clienteId") Long clienteId);
}
