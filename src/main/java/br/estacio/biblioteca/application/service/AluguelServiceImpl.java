package br.estacio.biblioteca.application.service;

import br.estacio.biblioteca.domain.entities.Aluguel;
import br.estacio.biblioteca.domain.entities.Cliente;
import br.estacio.biblioteca.domain.entities.Livro;
import br.estacio.biblioteca.domain.repository.AluguelRepository;
import br.estacio.biblioteca.domain.repository.ClienteRepository;
import br.estacio.biblioteca.domain.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelServiceImpl implements AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public Aluguel save(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    @Override
    public List<Aluguel> findAll() {
        return aluguelRepository.findAll();
    }

    @Override
    public Optional<Aluguel> findById(Long id) {
        return aluguelRepository.findById(id);
    }

    @Override
    public Aluguel update(Aluguel livro) {
        return aluguelRepository.save(livro);
    }

    @Override
    public void deleteById(Long id) {
        aluguelRepository.deleteById(id);
    }

    @Override
    public List<Aluguel> findAlugueisWithLivroByClienteId(Long clienteId) {
        return aluguelRepository.findAlugueisWithLivroByClienteId(clienteId);
    }
    @Transactional
    public Aluguel criarAluguel(Long clienteId, Long livroId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (!livro.isStatus()) {
            throw new RuntimeException("Livro já está alugado");
        }
        Aluguel aluguel = new Aluguel();
        aluguel.setCliente(cliente);
        aluguel.setLivro(livro);
        aluguel.prePersist();
        aluguelRepository.save(aluguel);
        livro.setStatus(false);
        livroRepository.save(livro);
        return aluguel;
    }

    @Override
    public Aluguel devolver(Long aluguelId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId)
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));
        aluguel.devolver();
        return aluguelRepository.save(aluguel);
    }
}
