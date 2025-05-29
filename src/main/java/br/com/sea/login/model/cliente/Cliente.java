package br.com.sea.login.model.cliente;

import br.com.sea.login.model.endereco.Endereco;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Table(name = "clientes")
@Entity(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @ElementCollection
    @CollectionTable(name = "cliente_telefones", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "telefone")
    private List<String> telefones;

    @ElementCollection
    @CollectionTable(name = "cliente_emails", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "email")
    private List<String> emails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;


    public Cliente(String nome, String cpf, List<String> telefones, List<String> emails, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefones = telefones;
        this.emails = emails;
        this.endereco = endereco;
    }

    public Cliente() {

    }

    public Cliente(ClienteDTO dto) {
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
