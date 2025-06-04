package br.com.sea.config;

import br.com.sea.model.cliente.ClienteDTO;
import br.com.sea.model.cliente.TipoTelefone;
import br.com.sea.model.endereco.EnderecoDTO;
import br.com.sea.model.usuario.UserRole;
import br.com.sea.model.usuario.Usuario;
import br.com.sea.repository.ClienteRepository;
import br.com.sea.repository.UsuarioRepository;
import br.com.sea.services.ClienteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    public DataInitializer(UsuarioRepository usuarioRepository, ClienteRepository clienteRepository, ClienteService clienteService) {
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (usuarioRepository.findByLogin("padrao") == null) {
            String encryptedPassword1 = new BCryptPasswordEncoder().encode("123qwe123");
            Usuario user1 = new Usuario("padrao", encryptedPassword1, UserRole.USER);
            usuarioRepository.save(user1);
        }

        if (usuarioRepository.findByLogin("admin") == null) {
            String encryptedPassword2 = new BCryptPasswordEncoder().encode("123qwe!@#");
            Usuario user2 = new Usuario("admin", encryptedPassword2, UserRole.ADMIN);
            usuarioRepository.save(user2);
        }
        if (clienteRepository.findByNome("Daniel Apoliano") == null) {
            ClienteDTO cliente = new ClienteDTO();
            cliente.setNome("Daniel Apoliano");
            cliente.setCpf("702.535.671-90");
            Map<TipoTelefone, String> telefones = new HashMap<>();
            telefones.put(TipoTelefone.CELULAR, "11999999999");
            telefones.put(TipoTelefone.RESIDENCIAL, "1122223333");
            telefones.put(TipoTelefone.COMERCIAL, "1133334444");
            cliente.setTelefones(telefones);
            cliente.setEmails(Arrays.asList("daniel@email.com", "contato@email.com"));
            EnderecoDTO endereco = new EnderecoDTO("70648-165", "123", "Velho", "Cruzeiro", "DF", "Perto do mercado");
            cliente.setEndereco(endereco);

            clienteService.registrarConta(cliente);
            System.out.println("Cliente inicial adicionado!");
        }
    }
}


