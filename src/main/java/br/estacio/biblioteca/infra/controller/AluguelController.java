package br.estacio.biblioteca.infra.controller;

import br.estacio.biblioteca.application.dto.ApiResponse;
import br.estacio.biblioteca.application.service.LivroService;
import br.estacio.biblioteca.domain.entities.Aluguel;
import br.estacio.biblioteca.application.service.AluguelService;
import br.estacio.biblioteca.domain.entities.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/alugueis")
@CrossOrigin(origins = "*")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;
    @Autowired
    private LivroService livroService;
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Aluguel>>> findAll() {
        List<Aluguel> alugueis = aluguelService.findAll();
        String message = alugueis.isEmpty() ? "Nenhum aluguel encontrado" : "Aluguéis encontrados com sucesso";
        return ResponseEntity.status(alugueis.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK)
                .body(new ApiResponse<>(message, alugueis));
    }

    @PutMapping("/devolver")
    public ResponseEntity<ApiResponse<Aluguel>> update(@RequestBody Aluguel aluguel) {
        Aluguel updatedAluguel = aluguelService.devolver(aluguel.getId());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Aluguel atualizado com sucesso", updatedAluguel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Aluguel>>> findById(@PathVariable Long id) {
        Optional<Aluguel> aluguel = aluguelService.findById(id);
        String message = aluguel.isPresent() ? "Aluguel encontrado" : "Aluguel não encontrado";
        return ResponseEntity.status(aluguel.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(message, aluguel));
    }

    @GetMapping("/cliente/{clientId}")
    public ResponseEntity<ApiResponse<List<Aluguel>>> findByClientId(@PathVariable Long clientId) {
        List<Aluguel> alugueis = aluguelService.findAlugueisWithLivroByClienteId(clientId);
        String message = alugueis.isEmpty() ? "Nenhum aluguel encontrado para este cliente" : "Aluguéis encontrados com sucesso";
        return ResponseEntity.status(alugueis.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK)
                .body(new ApiResponse<>(message, alugueis));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Aluguel>> create(@RequestBody Aluguel aluguel) {
        Aluguel createdAluguel = aluguelService.criarAluguel(aluguel.getCliente().getId(),aluguel.getLivro().getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Aluguel criado com sucesso", createdAluguel));
    }
}
