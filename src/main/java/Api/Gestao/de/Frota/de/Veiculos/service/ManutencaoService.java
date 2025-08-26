package Api.Gestao.de.Frota.de.Veiculos.service;

import Api.Gestao.de.Frota.de.Veiculos.exceptions.FrotaException;
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

    public List<Manutencao> listarManutencao() {
        return manutencaoRepository.findAll();
    }

    public Manutencao buscarPorId(Long id) {
        return manutencaoRepository.findById(id)
                .orElseThrow(() -> new FrotaException("Manutenção com ID " + id + " não encontrada"));
    }

    public Manutencao salvarManutencao(Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    public Manutencao atualizarManutencao(Long id, Manutencao manutencaoAtualizada) {
        Manutencao existente = buscarPorId(id);

        existente.setData(manutencaoAtualizada.getData());
        existente.setDescricao(manutencaoAtualizada.getDescricao());
        existente.setValor(manutencaoAtualizada.getValor());

        return manutencaoRepository.save(existente);
    }

    public void deletarManutencao(Long id) {
        if (!manutencaoRepository.existsById(id)) {
            throw new FrotaException("Manutenção com ID " + id + " não encontrada para exclusão");
        }
        manutencaoRepository.deleteById(id);
    }
}

