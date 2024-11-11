package br.estacio.biblioteca.controller;

import br.estacio.biblioteca.dto.ApiResponse;
import br.estacio.biblioteca.model.Livro;
import br.estacio.biblioteca.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Livro>>> findAll() {
        List<Livro> livros = livroService.findAll();
        String message = livros.isEmpty() ? "Nenhum livro encontrado" : "Livros encontrados com sucesso";
        return ResponseEntity.status(livros.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK)
                .body(new ApiResponse<>(message, livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Livro>> findById(@PathVariable Long id){
        Optional<Livro> livro = livroService.findById(id);
        if(livro.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(livro);
        }
        return ResponseEntity.status(livro.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(livro);
    }
    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livro));
    }

}
