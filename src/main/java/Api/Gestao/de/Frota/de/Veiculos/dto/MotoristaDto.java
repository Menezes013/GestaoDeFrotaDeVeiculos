package Api.Gestao.de.Frota.de.Veiculos.dto;

import Api.Gestao.de.Frota.de.Veiculos.model.Motorista;
import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class MotoristaDto {

    private Long id;
    private String nome;
    private String cpf;
    private String cnh;

    public MotoristaDto(Motorista motorista){
        BeanUtils.copyProperties(motorista, this);
    }
}
