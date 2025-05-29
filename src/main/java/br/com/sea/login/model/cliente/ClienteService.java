package br.com.sea.login.model.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void registrarConta(ClienteDTO dto) {

        Cliente cliente = new Cliente(dto);

        repository.save(cliente);
    }

}
