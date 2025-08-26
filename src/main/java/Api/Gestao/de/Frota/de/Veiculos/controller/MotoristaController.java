package Api.Gestao.de.Frota.de.Veiculos.controller;

import Api.Gestao.de.Frota.de.Veiculos.dto.MotoristaDto;
import Api.Gestao.de.Frota.de.Veiculos.model.Motorista;
import Api.Gestao.de.Frota.de.Veiculos.service.MotoristaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @Operation(summary = "Lista todos os motoristas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.")
    })

    @GetMapping
    public ResponseEntity<List<MotoristaDto>> listar() {
        List<MotoristaDto> motoristas = motoristaService.listarMotoristas()
                .stream()
                .map(MotoristaDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(motoristas);
    }

    @Operation(summary = "Busca um motorista pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca retornada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Motorista não encontrado")
    })

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaDto> buscarMotorista(@PathVariable Long id) {
        Motorista motorista = motoristaService.buscarPorId(id);
        return ResponseEntity.ok(new MotoristaDto(motorista));
    }

    @Operation(summary = "Cadastro de um motorista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado com sucesso.")
    })

    @PostMapping
    public ResponseEntity<MotoristaDto> criarMotorista(@Valid @RequestBody MotoristaDto motoristaDto) {
        Motorista motorista = motoristaDto.toEntity();
        Motorista salvo = motoristaService.salvar(motorista);
        return ResponseEntity.ok(new MotoristaDto(salvo));
    }

    @Operation(summary = "Atualiza um motorista pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Motorista atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Motorista não encontrado")
    })

    @PutMapping("/{id}")
    public ResponseEntity<MotoristaDto> atualizarMotorista(
            @PathVariable Long id,
            @Valid @RequestBody MotoristaDto motoristaDto) {

        Motorista motoristaAtualizado = motoristaService.atualizarMotorista(id, motoristaDto.toEntity());
        return ResponseEntity.ok(new MotoristaDto(motoristaAtualizado));
    }

    @Operation(summary = "Deleta um motorista por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Motorista não encontrado")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        motoristaService.deletarMotorista(id);
        return ResponseEntity.noContent().build();
    }
}

