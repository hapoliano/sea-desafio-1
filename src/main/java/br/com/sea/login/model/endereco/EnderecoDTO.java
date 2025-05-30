package br.com.sea.login.model.endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EnderecoDTO {

    @NotBlank
    @Pattern(regexp = "^\\d{5}-\\d{3}$")
    private String cep;
    @NotBlank
    private String logradouro;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String uf;
    private String complemento;

    public @NotBlank String getCep() {
        return cep;
    }

    public void setCep(@NotBlank String cep) {
        this.cep = cep;
    }

    public @NotBlank String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(@NotBlank String logradouro) {
        this.logradouro = logradouro;
    }

    public @NotBlank String getBairro() {
        return bairro;
    }

    public void setBairro(@NotBlank String bairro) {
        this.bairro = bairro;
    }

    public @NotBlank String getCidade() {
        return cidade;
    }

    public void setCidade(@NotBlank String cidade) {
        this.cidade = cidade;
    }

    public @NotBlank String getUf() {
        return uf;
    }

    public void setUf(@NotBlank String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
