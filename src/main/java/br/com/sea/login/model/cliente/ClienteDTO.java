package br.com.sea.login.model.cliente;

import br.com.sea.login.model.endereco.EnderecoDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class ClienteDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String nome;

    @NotBlank
    private String cpf;

    @NotEmpty
    private List<String> telefones;

    @NotEmpty
    private List<String> emails;

    @NotNull
    private EnderecoDTO endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
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
