package Api.Gestao.de.Frota.de.Veiculos.dto;

import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

public class VeiculoDto {

    private Long id;

    @NotBlank(message = "A placa é obrigatória")
    private String placa;

    @NotBlank(message = "A marca é obrigatória")
    private String marca;

    @NotBlank(message = "O modelo é obrigatório")
    private String modelo;

    @NotNull(message = "O ano é obrigatório")
    private Integer ano;

    public VeiculoDto(Veiculo veiculo) {
        BeanUtils.copyProperties(veiculo, this);
    }

    public Veiculo toEntity() {
        Veiculo veiculo = new Veiculo();
        BeanUtils.copyProperties(this, veiculo);
        return veiculo;
    }

    public VeiculoDto(Long id, String placa, String marca, String modelo, Integer ano) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
