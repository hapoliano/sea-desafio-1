package br.com.sea.login.controller;

import br.com.sea.login.model.cliente.ClienteDTO;
import br.com.sea.login.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clientes")
@Tag(name = "Clientes", description = "APIs para o cadastrado e a listagem clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Transactional
    @PostMapping("/cadastrar")
    @Operation(description = "endpoint para cadastrar um cliente.")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ClienteDTO dados ) {
        clienteService.registrarConta(dados);
        return ResponseEntity.ok().build();
    }

    @Operation(description = "endpoint para listagem de todos os clientes.")
    @GetMapping("/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        List<ClienteDTO> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }
}
