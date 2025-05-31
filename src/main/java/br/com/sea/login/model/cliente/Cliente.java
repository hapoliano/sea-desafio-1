package br.com.sea.login.model.cliente;

import br.com.sea.login.model.endereco.Endereco;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Table(name = "clientes")
@Entity(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cpf;
    @ElementCollection
    @CollectionTable(name = "cliente_telefones", joinColumns = @JoinColumn(name = "cliente_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "tipo")
    @Column(name = "telefone")
    private Map<TipoTelefone, String> telefones;
    @ElementCollection
    @CollectionTable(name = "cliente_emails", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "email")
    private List<String> emails;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(ClienteDTO dto) {
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
        this.telefones = dto.getTelefones();
        this.emails = dto.getEmails();
        this.endereco = new Endereco(dto.getEndereco());
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

    public Map<TipoTelefone, String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Map<TipoTelefone, String> telefones) {
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
