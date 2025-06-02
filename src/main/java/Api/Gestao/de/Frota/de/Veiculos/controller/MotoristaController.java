package Api.Gestao.de.Frota.de.Veiculos.controller;

import Api.Gestao.de.Frota.de.Veiculos.model.Motorista;
import Api.Gestao.de.Frota.de.Veiculos.service.MotoristaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/motorista")
public class MotoristaController {

    private final MotoristaService motoristaService;

    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @GetMapping
    public List<Motorista> listar() {
        return motoristaService.listarMotoristas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarVeiculo(@PathVariable Long id){
        Motorista motorista = motoristaService.buscarPorId(id);
        return ResponseEntity.ok(motorista);
    }

    @PostMapping
    public Motorista criarMotorista(@RequestBody Motorista motorista){
        return motoristaService.salvar(motorista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        motoristaService.deletarMotorista(id);
        return ResponseEntity.noContent().build();
    }

}
