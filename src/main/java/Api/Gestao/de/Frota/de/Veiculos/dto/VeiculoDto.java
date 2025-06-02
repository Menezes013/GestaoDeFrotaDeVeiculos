package Api.Gestao.de.Frota.de.Veiculos.dto;

import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class VeiculoDto {

    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private int ano;

    public VeiculoDto(Veiculo veiculo){
        BeanUtils.copyProperties(veiculo, this);
    }
}
