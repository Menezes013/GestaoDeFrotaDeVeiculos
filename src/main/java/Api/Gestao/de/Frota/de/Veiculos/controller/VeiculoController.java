package Api.Gestao.de.Frota.de.Veiculos.controller;

import Api.Gestao.de.Frota.de.Veiculos.dto.VeiculoDto;
import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import Api.Gestao.de.Frota.de.Veiculos.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;


    @Operation(summary = "Lista todos os veículos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso.")
    })
    @GetMapping
    public ResponseEntity<List<VeiculoDto>> listarVeiculos(){
        List<Veiculo> veiculos = veiculoService.listarVeiculos();


        List<VeiculoDto> veiculosDto = veiculos.stream()
                .map(VeiculoDto::new)
                .toList();

        return ResponseEntity.ok(veiculosDto);
    }

    @Operation(summary = "Busca um veículo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca retornada com sucesso."),
            @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDto> buscarVeiculo(@PathVariable Long id){
        Veiculo veiculo = veiculoService.buscarPorId(id);
        return ResponseEntity.ok(new VeiculoDto(veiculo));
    }

    @Operation(summary = "Cadastro de um veículo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criado com sucesso.")
    })
    @PostMapping
    public ResponseEntity<VeiculoDto> criarVeiculo(@RequestBody @Valid VeiculoDto veiculoDto){
        Veiculo salvo = veiculoService.salvarVeiculo(veiculoDto);
        return ResponseEntity.ok(new VeiculoDto(salvo));
    }

    @Operation(summary = "Atualiza os dados de um veículo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDto> atualizarVeiculo(@PathVariable Long id, @RequestBody @Valid VeiculoDto veiculoDto) {
        Veiculo atualizado = veiculoService.atualizarVeiculo(id, veiculoDto);
        return ResponseEntity.ok(new VeiculoDto(atualizado));
    }

    @Operation(summary = "Deleta um veículo por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deletado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Veículo não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id){
        veiculoService.deletarVeiculo(id);
        return ResponseEntity.noContent().build();
    }
}


