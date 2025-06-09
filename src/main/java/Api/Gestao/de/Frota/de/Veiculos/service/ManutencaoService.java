package Api.Gestao.de.Frota.de.Veiculos.service;

import Api.Gestao.de.Frota.de.Veiculos.model.Manutencao;
import Api.Gestao.de.Frota.de.Veiculos.repository.ManutencaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {

    private final ManutencaoRepository manutencaoRepository;

    public ManutencaoService(ManutencaoRepository manutencaoRepository) {
        this.manutencaoRepository = manutencaoRepository;
    }

    public List<Manutencao> listarManutencao(){
        return manutencaoRepository.findAll();
    }

    public Manutencao buscarPorId(Long id){
        return manutencaoRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Tipo de manutenção não encontrado"));
    }

    public Manutencao salvarManutencao(Manutencao manutencao){
        return manutencaoRepository.save(manutencao);
    }

    public void deletarManutencao(Long id){
        if (!manutencaoRepository.existsById(id)){
            throw new RuntimeException("Manutenção com ID "+id +"não encontrado");
        }

        manutencaoRepository.deleteById(id);
    }
}
