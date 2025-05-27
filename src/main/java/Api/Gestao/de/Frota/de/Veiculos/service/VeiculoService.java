package Api.Gestao.de.Frota.de.Veiculos.service;

import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import Api.Gestao.de.Frota.de.Veiculos.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    // Método para listar todos os veiculos
    public List<Veiculo> listarVeiculos(){
        return veiculoRepository.findAll();
    }

    // Método para buscar veiculos pelo ID
     public Veiculo buscarPorId(Long id){
        return veiculoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Veículo não encontrado com ID: " + id));
     }

     // Método para salvar veiculo no banco de dados
     public Veiculo salvarVeiculo(Veiculo veiculo){
         return veiculoRepository.save(veiculo);
     }

     // Método para excluir veiculo
     public void deletarVeiculo(Long id){
         if (!veiculoRepository.existsById(id)) {
             throw new RuntimeException("Veículo não encontrado para exclusão com ID: " + id);
         }
         veiculoRepository.deleteById(id);

     }


}
