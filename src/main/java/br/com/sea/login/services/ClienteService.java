package br.com.sea.login.services;

import br.com.sea.login.model.cliente.Cliente;
import br.com.sea.login.model.cliente.ClienteDTO;
import br.com.sea.login.repository.ClienteRepository;
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
        if (!isValidCpf(dto.getCpf())) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        Cliente cliente = new Cliente(dto);
        repository.save(cliente);
    }

    public List<ClienteDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(ClienteDTO::new)
                .collect(Collectors.toList());
    }

    public boolean isValidCpf(String cpf) {
        if (cpf == null) return false;

        cpf = cpf.replaceAll("\\D", ""); // Remove pontos e traços

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        int firstDigit = calculateDigit(cpf.substring(0, 9), 10);
        int secondDigit = calculateDigit(cpf.substring(0, 10), 11);

        return cpf.endsWith("" + firstDigit + secondDigit);
    }

    private int calculateDigit(String str, int weight) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (str.charAt(i) - '0') * (weight - i);
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }
}
