package Api.Gestao.de.Frota.de.Veiculos.dto;

import Api.Gestao.de.Frota.de.Veiculos.model.Manutencao;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
public class ManutencaoDto {

    private Long id;
    private LocalDate data;
    private String descricao;
    private Double valor;

    public ManutencaoDto(Manutencao manutencao){
        BeanUtils.copyProperties(manutencao, this);
    }
}
