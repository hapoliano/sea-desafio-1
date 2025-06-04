package br.com.sea.controller;

import br.com.sea.infra.security.TokenService;
import br.com.sea.model.usuario.AuthenticatioDTO;
import br.com.sea.model.usuario.LoginResponseDTO;
import br.com.sea.model.usuario.RegisterDTO;
import br.com.sea.model.usuario.Usuario;
import br.com.sea.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
@Tag(name = "Autenticação", description = "APIs para o registro e login")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UsuarioRepository usuarioRepository;

    private final TokenService tokenService;

    public AuthenticationController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    @Operation(description = "endpoint para login do usuario.")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticatioDTO data) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/registrar")
    @Operation(description = "endpoint para registrar um usuario.")
    public ResponseEntity<Void> registrar(@RequestBody @Valid RegisterDTO data) {
        if(this.usuarioRepository.findByLogin(data.getLogin()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());
        Usuario newUser = new Usuario(data.getLogin(), encryptedPassword, data.getRole());

        this.usuarioRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
