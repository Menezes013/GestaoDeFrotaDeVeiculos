package Api.Gestao.de.Frota.de.Veiculos.controller;

import Api.Gestao.de.Frota.de.Veiculos.model.Manutencao;
import Api.Gestao.de.Frota.de.Veiculos.service.ManutencaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manutencao")
public class ManutencaoController {

    private final ManutencaoService manutencaoService;

    public ManutencaoController(ManutencaoService manutencaoService) {
        this.manutencaoService = manutencaoService;
    }

    @GetMapping
    public List<Manutencao> listarManutencao(){
        return manutencaoService.listarManutencao();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarManutencao(@PathVariable Long id){
        Manutencao manutencao = manutencaoService.buscarPorId(id);
        return ResponseEntity.ok(manutencao);
    }

    @PostMapping
    public Manutencao criarManutencao(@RequestBody Manutencao manutencao){
        return manutencaoService.salvarManutencao(manutencao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarManutencao(@PathVariable Long id){
        manutencaoService.deletarManutencao(id);
        return ResponseEntity.noContent().build();
    }
}
