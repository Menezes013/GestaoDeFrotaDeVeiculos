package Api.Gestao.de.Frota.de.Veiculos.service;

import Api.Gestao.de.Frota.de.Veiculos.model.Motorista;
import Api.Gestao.de.Frota.de.Veiculos.repository.MotoristaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    private final MotoristaRepository motoristaRepository;

    public MotoristaService(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }

    public List<Motorista> listarMotoristas() {
        return motoristaRepository.findAll();
    }

    public Motorista buscarPorId(Long id){
        return motoristaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Motorista com ID "+id+" não encontrado"));
    }

    public Motorista salvar(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    public void deletarMotorista(Long id) {

        if (!motoristaRepository.existsById(id)){
            throw new RuntimeException("Motorista não encontrado para exclusão com ID: " + id);
        }
        motoristaRepository.deleteById(id);
    }

}
