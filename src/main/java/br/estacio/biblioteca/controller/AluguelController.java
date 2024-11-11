package br.estacio.biblioteca.controller;

import br.estacio.biblioteca.dto.ApiResponse;
import br.estacio.biblioteca.model.Aluguel;
import br.estacio.biblioteca.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/alugueis")
public class AluguelController {
    @Autowired
    private AluguelService aluguelService;
    @GetMapping

    public ResponseEntity<ApiResponse<List<Aluguel>>> findAll() {
        List<Aluguel> algueis = aluguelService.findAll();
        String message = algueis.isEmpty() ? "Nenhum aluguel encontrado" : "Alugueis encontrados com sucesso";
        return ResponseEntity.status(algueis.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK)
                .body(new ApiResponse<>(message, algueis));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Aluguel>> findById(@PathVariable Long id){
        Optional<Aluguel>  aluguel = aluguelService.findById(id);
        if(aluguel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(aluguel);
        }
        return ResponseEntity.status(aluguel.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(aluguel);
    }
    @PostMapping
    public ResponseEntity<Aluguel> create(@RequestBody Aluguel aluguel){
        return ResponseEntity.status(HttpStatus.CREATED).body(aluguelService.save(aluguel));
    }
}
