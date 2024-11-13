package br.estacio.biblioteca.application.service;

import br.estacio.biblioteca.domain.entities.Livro;
import br.estacio.biblioteca.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Override
    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    @Override
    public Livro update(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }
}
