package Api.Gestao.de.Frota.de.Veiculos.model;

import jakarta.persistence.*;

@Entity
@Table (name = "tb_motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String cnh;
    public Motorista() {
    }

    public Motorista(String nome, String cpf, String cnh) {
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
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

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}
