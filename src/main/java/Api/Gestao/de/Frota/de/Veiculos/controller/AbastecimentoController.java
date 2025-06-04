package Api.Gestao.de.Frota.de.Veiculos.controller;

import Api.Gestao.de.Frota.de.Veiculos.model.Abastecimento;
import Api.Gestao.de.Frota.de.Veiculos.service.AbastecimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/abastecimento")
public class AbastecimentoController {

    private final AbastecimentoService abastecimentoService;

    public AbastecimentoController(AbastecimentoService abastecimentoService) {
        this.abastecimentoService = abastecimentoService;
    }

    @GetMapping
    public List<Abastecimento> listarAbastecimento() {
        return abastecimentoService.listarAbastecimento();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAbastecimento(@PathVariable Long id) {
        Optional<Abastecimento> abastecimento = abastecimentoService.buscarPorId(id);
        return ResponseEntity.ok(abastecimento);
    }

    @PostMapping
    public Abastecimento criarAbastecimento(@RequestBody Abastecimento abastecimento) {
        return abastecimentoService.salvar(abastecimento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAbastecimento(@PathVariable Long id) {
        abastecimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
