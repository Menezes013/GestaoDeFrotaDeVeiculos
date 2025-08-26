package Api.Gestao.de.Frota.de.Veiculos.dto;

import Api.Gestao.de.Frota.de.Veiculos.model.Manutencao;
import jakarta.validation.constraints.*;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ManutencaoDto {

    private Long id;

    @NotNull(message = "A data da manutenção é obrigatória")
    private LocalDate data;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 255, message = "A descrição não pode passar de 255 caracteres")
    private String descricao;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que 0")
    private BigDecimal valor;

    public ManutencaoDto(Manutencao manutencao) {
        BeanUtils.copyProperties(manutencao, this);
    }

    public Manutencao toEntity() {
        Manutencao manutencao = new Manutencao();
        BeanUtils.copyProperties(this, manutencao);
        return manutencao;
    }

    public ManutencaoDto(Long id, LocalDate data, String descricao, BigDecimal valor) {
        this.id = id;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

