package br.estacio.biblioteca.service;

import br.estacio.biblioteca.model.Aluguel;
import br.estacio.biblioteca.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelServiceImpl implements AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;
    @Override
    public Aluguel save(Aluguel alguel) {
        return aluguelRepository.save(alguel);
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
}
