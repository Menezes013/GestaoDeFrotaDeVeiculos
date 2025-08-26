package Api.Gestao.de.Frota.de.Veiculos.dto;

import Api.Gestao.de.Frota.de.Veiculos.model.Abastecimento;
import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AbastecimentoDto {

    @NotNull(message = "O ID do veículo é obrigatório")
    private Long veiculoId;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor deve ser maior que 0")
    private BigDecimal valor;

    @NotNull(message = "A quantidade de litros é obrigatória")
    @DecimalMin(value = "0.01", message = "Os litros devem ser maiores que 0")
    private BigDecimal litros;

    @NotNull(message = "A data do abastecimento é obrigatória")
    private LocalDate data;

    public AbastecimentoDto(Abastecimento abastecimento) {
        BeanUtils.copyProperties(abastecimento, this);
        if (abastecimento.getVeiculo() != null) {
            this.veiculoId = abastecimento.getVeiculo().getId();
        }
    }

    public Abastecimento toEntity(Veiculo veiculo) {
        Abastecimento abastecimento = new Abastecimento();
        BeanUtils.copyProperties(this, abastecimento);
        abastecimento.setVeiculo(veiculo);
        return abastecimento;
    }

    public AbastecimentoDto(Long veiculoId, BigDecimal valor, BigDecimal litros, LocalDate data) {
        this.veiculoId = veiculoId;
        this.valor = valor;
        this.litros = litros;
        this.data = data;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

