package Api.Gestao.de.Frota.de.Veiculos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_abastecimento")
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;
    private double valor;
    private double litros;
    private LocalDate data;

    public Abastecimento() {
    }

    public Abastecimento(Veiculo veiculo, double valor, double litros, LocalDate data) {
        this.veiculo = veiculo;
        this.valor = valor;
        this.litros = litros;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "id=" + id +
                ", veiculoId=" + (veiculo != null ? veiculo.getId() : null) +
                ", valor=" + valor +
                ", litros=" + litros +
                ", data=" + data +
                '}';
    }

}
