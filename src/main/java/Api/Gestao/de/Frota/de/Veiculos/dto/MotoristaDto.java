package Api.Gestao.de.Frota.de.Veiculos.dto;

import Api.Gestao.de.Frota.de.Veiculos.model.Motorista;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.BeanUtils;

public class MotoristaDto {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
    private String cpf;

    @NotBlank(message = "CNH é obrigatória")
    @Size(min = 11, max = 11, message = "CNH deve conter exatamente 11 caracteres")
    private String cnh;

    public MotoristaDto(Motorista motorista) {
        BeanUtils.copyProperties(motorista, this);
    }

    public Motorista toEntity() {
        Motorista motorista = new Motorista();
        BeanUtils.copyProperties(this, motorista);
        return motorista;
    }

    public MotoristaDto(Long id, String nome, String cpf, String cnh) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
}

