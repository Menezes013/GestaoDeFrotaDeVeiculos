package Api.Gestao.de.Frota.de.Veiculos.controller;

import Api.Gestao.de.Frota.de.Veiculos.dto.ManutencaoDto;
import Api.Gestao.de.Frota.de.Veiculos.model.Manutencao;
import Api.Gestao.de.Frota.de.Veiculos.service.ManutencaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/manutencao")
public class ManutencaoController {

    @Autowired
    private ManutencaoService manutencaoService;

    @Operation(summary = "Lista todas as manutenções")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.")
    })

    @GetMapping
    public ResponseEntity<List<ManutencaoDto>> listarManutencao() {
        List<ManutencaoDto> manutencoes = manutencaoService.listarManutencao()
                .stream()
                .map(ManutencaoDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(manutencoes);
    }


    @Operation(summary = "Busca uma manutenção pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca retornada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Manutenção não encontrado")
    })

    @GetMapping("/{id}")
    public ResponseEntity<ManutencaoDto> buscarManutencao(@PathVariable Long id) {
        Manutencao manutencao = manutencaoService.buscarPorId(id);
        return ResponseEntity.ok(new ManutencaoDto(manutencao));
    }

    @Operation(summary = "Cadastro de uma manutenção")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado com sucesso.")
    })

    @PostMapping
    public ResponseEntity<ManutencaoDto> criarManutencao(@Valid @RequestBody ManutencaoDto manutencaoDto) {
        Manutencao manutencao = manutencaoDto.toEntity();
        Manutencao salvo = manutencaoService.salvarManutencao(manutencao);
        return ResponseEntity.ok(new ManutencaoDto(salvo));
    }

    @Operation(summary = "Atualiza uma manutenção pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Manutenção atualizada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Manutenção não encontrado")
    })

    @PutMapping("/{id}")
    public ResponseEntity<ManutencaoDto> atualizarManutencao(@PathVariable Long id,
                                                             @Valid @RequestBody ManutencaoDto manutencaoDto) {
        Manutencao atualizado = manutencaoService.atualizarManutencao(id, manutencaoDto.toEntity());
        return ResponseEntity.ok(new ManutencaoDto(atualizado));
    }

    @Operation(summary = "Deleta uma manutenção pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Manutenção não encontrada")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarManutencao(@PathVariable Long id) {
        manutencaoService.deletarManutencao(id);
        return ResponseEntity.noContent().build();
    }
}

