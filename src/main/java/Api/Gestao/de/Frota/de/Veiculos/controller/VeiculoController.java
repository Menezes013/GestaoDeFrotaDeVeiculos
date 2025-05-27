package Api.Gestao.de.Frota.de.Veiculos.controller;

import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import Api.Gestao.de.Frota.de.Veiculos.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    // Listar todos os veículos
    @GetMapping
    public List<Veiculo> listarVeiculos(){
        return veiculoService.listarVeiculos();
    }

    // Buscar veículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarVeiculo(@PathVariable Long id){
        Veiculo veiculo = veiculoService.buscarPorId(id);
        return ResponseEntity.ok(veiculo);
    }

    // Cadastrar novo veículo
    @PostMapping
    public Veiculo criarVeiculo(@RequestBody Veiculo veiculo){
        return veiculoService.salvarVeiculo(veiculo);
    }


    // Deletar veículo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id){
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}
