package Api.Gestao.de.Frota.de.Veiculos.dto;

import Api.Gestao.de.Frota.de.Veiculos.model.Abastecimento;
import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
public class AbastecimentoDto {

    private Veiculo veiculo;
    private double valor;
    private double litros;
    private LocalDate data;

    public AbastecimentoDto(Abastecimento abastecimento){
        BeanUtils.copyProperties(abastecimento, this);
    }
}
