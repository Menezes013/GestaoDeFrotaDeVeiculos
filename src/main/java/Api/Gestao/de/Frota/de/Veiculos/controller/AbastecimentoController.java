package Api.Gestao.de.Frota.de.Veiculos.controller;

import Api.Gestao.de.Frota.de.Veiculos.dto.AbastecimentoDto;
import Api.Gestao.de.Frota.de.Veiculos.model.Abastecimento;
import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import Api.Gestao.de.Frota.de.Veiculos.service.AbastecimentoService;
import Api.Gestao.de.Frota.de.Veiculos.service.VeiculoService;
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
@RequestMapping("/api/abastecimento")
public class AbastecimentoController {

    @Autowired
    private AbastecimentoService abastecimentoService;

    @Autowired
    private VeiculoService veiculoService;

    @Operation(summary = "Lista todos os abastecimentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.")
    })

    @GetMapping
    public ResponseEntity<List<AbastecimentoDto>> listarAbastecimento() {
        List<AbastecimentoDto> abastecimentos = abastecimentoService.listarAbastecimento()
                .stream()
                .map(AbastecimentoDto::new) // Entity -> DTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(abastecimentos);
    }

    @Operation(summary = "Busca um abastecimento pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca retornada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Abastecimento não encontrado")
    })

    @GetMapping("/{id}")
    public ResponseEntity<AbastecimentoDto> buscarAbastecimento(@PathVariable Long id) {
        Abastecimento abastecimento = abastecimentoService.buscarPorId(id);
        return ResponseEntity.ok(new AbastecimentoDto(abastecimento));
    }

    @Operation(summary = "Cadastro de um abastecimento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado com sucesso.")
    })

    @PostMapping
    public ResponseEntity<AbastecimentoDto> criarAbastecimento(@Valid @RequestBody AbastecimentoDto abastecimentoDto) {
        Veiculo veiculo = veiculoService.buscarPorId(abastecimentoDto.getVeiculoId()); // busca veículo pelo ID
        Abastecimento abastecimento = abastecimentoDto.toEntity(veiculo);
        Abastecimento salvo = abastecimentoService.salvar(abastecimento);
        return ResponseEntity.ok(new AbastecimentoDto(salvo));
    }

    @Operation(summary = "Atualiza um abastecimento pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Abastecimento atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Abastecimento não encontrado")
    })

    @PutMapping("/{id}")
    public ResponseEntity<AbastecimentoDto> atualizarAbastecimento(@PathVariable Long id,
                                                                   @Valid @RequestBody AbastecimentoDto abastecimentoDto) {
        Veiculo veiculo = veiculoService.buscarPorId(abastecimentoDto.getVeiculoId());
        Abastecimento atualizado = abastecimentoDto.toEntity(veiculo);
        Abastecimento salvo = abastecimentoService.atualizar(id, atualizado);
        return ResponseEntity.ok(new AbastecimentoDto(salvo));
    }

    @Operation(summary = "Deleta um abastecimento pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "abastecimento não encontrada")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAbastecimento(@PathVariable Long id) {
        abastecimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

