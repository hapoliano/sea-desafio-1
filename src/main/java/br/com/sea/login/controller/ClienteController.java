package br.com.sea.login.controller;

import br.com.sea.login.model.cliente.ClienteDTO;
import br.com.sea.login.repository.ClienteRepository;
import br.com.sea.login.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ClienteDTO dados ) {
        clienteService.registrarConta(dados);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity listarClientes() {
        List<ClienteDTO> clientes = clienteService.listarTodos();
        return ResponseEntity.ok(clientes);
    }
}
