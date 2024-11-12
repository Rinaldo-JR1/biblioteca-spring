package br.estacio.biblioteca.controller;

import br.estacio.biblioteca.dto.ApiResponse;
import br.estacio.biblioteca.model.Cliente;
import br.estacio.biblioteca.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ApiResponse<Cliente>> save(@RequestBody Cliente cliente) {
        Cliente savedCliente = clienteService.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Cliente criado com sucesso", savedCliente));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Cliente>>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        String message = clientes.isEmpty() ? "Nenhum cliente encontrado" : "Clientes encontrados com sucesso";
        return ResponseEntity.status(clientes.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK)
                .body(new ApiResponse<>(message, clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Optional<Cliente>>> findById(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.findById(id);
        String message = cliente.isPresent() ? "Cliente encontrado" : "Cliente não encontrado";
        return ResponseEntity.status(cliente.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(message, cliente));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Cliente>> update(@RequestBody Cliente cliente) {
        Cliente updatedCliente = clienteService.update(cliente);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Cliente atualizado com sucesso", updatedCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Cliente deletado com sucesso", null));
    }
}
