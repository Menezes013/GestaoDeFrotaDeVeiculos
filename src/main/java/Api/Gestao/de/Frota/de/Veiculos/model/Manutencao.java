package Api.Gestao.de.Frota.de.Veiculos.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "tb_manutencao")

public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private String descricao;
    private Double valor;

    public Manutencao(){
    }

    public Manutencao(String veiculo, LocalDate data, String descricao, Double valor) {
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
