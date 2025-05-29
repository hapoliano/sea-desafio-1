package br.com.sea.login.model.endereco;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String cep;
    @Column
    private String logradouro;
    @Column
    private String bairro;
    @Column
    private String cidade;
    @Column
    private String uf;
    @Column
    private String complemento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
