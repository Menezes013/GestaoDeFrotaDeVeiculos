package Api.Gestao.de.Frota.de.Veiculos.service;

import Api.Gestao.de.Frota.de.Veiculos.dto.VeiculoDto;
import Api.Gestao.de.Frota.de.Veiculos.exceptions.FrotaException;
import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import Api.Gestao.de.Frota.de.Veiculos.repository.VeiculoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;


    public List<Veiculo> listarVeiculos(){
        return veiculoRepository.findAll();
    }


    public Veiculo buscarPorId(Long id){
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new FrotaException("Veículo não encontrado com ID: " + id));
    }


    public Veiculo atualizarVeiculo(Long id, @Valid VeiculoDto veiculoAtualizado) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new FrotaException("Veículo não encontrado com ID: " + id));

        BeanUtils.copyProperties(veiculoAtualizado, veiculo, "id");

        return veiculoRepository.save(veiculo);
    }


    public Veiculo salvarVeiculo(@Valid VeiculoDto veiculoDto){
        Veiculo veiculo = new Veiculo();
        BeanUtils.copyProperties(veiculoDto, veiculo);

        return veiculoRepository.save(veiculo);
    }

    public void deletarVeiculo(Long id){
        if (!veiculoRepository.existsById(id)) {
            throw new FrotaException("Veículo não encontrado para exclusão com ID: " + id);
        }
        veiculoRepository.deleteById(id);
    }
}

