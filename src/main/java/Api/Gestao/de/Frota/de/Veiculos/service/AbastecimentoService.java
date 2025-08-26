package Api.Gestao.de.Frota.de.Veiculos.service;

import Api.Gestao.de.Frota.de.Veiculos.exceptions.FrotaException;
import Api.Gestao.de.Frota.de.Veiculos.model.Abastecimento;
import Api.Gestao.de.Frota.de.Veiculos.repository.AbastecimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public List<Abastecimento> listarAbastecimento() {
        return abastecimentoRepository.findAll();
    }

    public Abastecimento buscarPorId(Long id) {
        return abastecimentoRepository.findById(id)
                .orElseThrow(() -> new FrotaException("Abastecimento com ID " + id + " não encontrado"));
    }

    public Abastecimento salvar(Abastecimento abastecimento) {
        return abastecimentoRepository.save(abastecimento);
    }

    public Abastecimento atualizar(Long id, Abastecimento abastecimentoAtualizado) {
        Abastecimento existente = buscarPorId(id);

        existente.setData(abastecimentoAtualizado.getData());
        existente.setValor(abastecimentoAtualizado.getValor());
        existente.setLitros(abastecimentoAtualizado.getLitros());
        existente.setVeiculo(abastecimentoAtualizado.getVeiculo());

        return abastecimentoRepository.save(existente);
    }

    public void deletar(Long id) {
        if (!abastecimentoRepository.existsById(id)) {
            throw new FrotaException("Abastecimento com ID " + id + " não encontrado para exclusão");
        }
        abastecimentoRepository.deleteById(id);
    }
}

