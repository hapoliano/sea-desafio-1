package br.com.sea.login.model.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void registrarConta(@Valid ClienteDTO dto) {
        Cliente cliente = new Cliente(dto);
        repository.save(cliente);
    }

}
