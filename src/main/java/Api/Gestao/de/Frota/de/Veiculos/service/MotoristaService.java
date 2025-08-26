package Api.Gestao.de.Frota.de.Veiculos.service;

import Api.Gestao.de.Frota.de.Veiculos.exceptions.FrotaException;
import Api.Gestao.de.Frota.de.Veiculos.model.Motorista;
import Api.Gestao.de.Frota.de.Veiculos.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<Motorista> listarMotoristas() {
        return motoristaRepository.findAll();
    }

    public Motorista buscarPorId(Long id) {
        return motoristaRepository.findById(id)
                .orElseThrow(() -> new FrotaException("Motorista com ID " + id + " não encontrado"));
    }

    public Motorista salvar(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    public Motorista atualizarMotorista(Long id, Motorista motoristaAtualizado) {
        Motorista existente = buscarPorId(id);
        existente.setNome(motoristaAtualizado.getNome());
        existente.setCnh(motoristaAtualizado.getCnh());

        return salvar(existente);
    }

    public void deletarMotorista(Long id) {
        if (!motoristaRepository.existsById(id)) {
            throw new FrotaException("Motorista não encontrado para exclusão com ID: " + id);
        }
        motoristaRepository.deleteById(id);
    }
}
