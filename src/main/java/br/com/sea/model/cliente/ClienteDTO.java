package br.com.sea.model.cliente;

import br.com.sea.model.endereco.EnderecoDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClienteDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    @Pattern(regexp = "^[A-Za-z0-9À-ÿ ]+$")
    private String nome;
    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")
    private String cpf;
    @Schema(description = "Lista de telefones do cliente com tipo e número", example = "{\"CELULAR\": \"11999999999\", \"RESIDENCIAL\": \"1122223333\", \"COMERCIAL\": \"1133334444\"}")
    @NotEmpty
    private Map<TipoTelefone, String> telefones;
    @NotEmpty
    private List<@Email String> emails;
    @NotNull
    @Valid
    private EnderecoDTO endereco;

    public ClienteDTO(){}

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefones = cliente.getTelefones();
        this.emails = cliente.getEmails();
        this.endereco = new EnderecoDTO(cliente.getEndereco());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf.replaceAll("\\D", "");
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public @NotEmpty Map<TipoTelefone, String> getTelefones() {
        return telefones.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().replaceAll("\\D", "")
                ));
    }

    public void setTelefones(@NotEmpty Map<TipoTelefone, String> telefones) {
        this.telefones = telefones;
    }

    public @NotEmpty List<String> getEmails() {
        return emails;
    }

    public void setEmails(@NotEmpty List<String> emails) {
        this.emails = emails;
    }

    public @NotNull EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
