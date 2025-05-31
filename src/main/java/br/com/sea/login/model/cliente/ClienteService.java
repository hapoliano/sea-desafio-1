package br.com.sea.login.model.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void registrarConta(@Valid ClienteDTO dto) {
        Cliente cliente = new Cliente(dto);
        repository.save(cliente);
    }

    public List<ClienteDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ClienteDTO::from)
                .collect(Collectors.toList());
    }

}
