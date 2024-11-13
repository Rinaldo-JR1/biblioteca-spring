package br.estacio.biblioteca.domain.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean status = true;

    @PrePersist
    public void prePersist() {
        this.dataInicio = LocalDate.now();
        this.dataFim = this.dataInicio.plusWeeks(1);
        this.livro.setStatus(false);
    }

    public void devolver() {
        this.status = false;
        this.livro.setStatus(true);
    }
}
