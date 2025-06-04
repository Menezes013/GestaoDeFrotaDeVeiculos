package Api.Gestao.de.Frota.de.Veiculos.service;

import Api.Gestao.de.Frota.de.Veiculos.model.Abastecimento;
import Api.Gestao.de.Frota.de.Veiculos.repository.AbastecimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbastecimentoService {

    private final AbastecimentoRepository abastecimentoRepository;

    public AbastecimentoService(AbastecimentoRepository abastecimentoRepository) {
        this.abastecimentoRepository = abastecimentoRepository;
    }

    public List<Abastecimento> listarAbastecimento(){
        return abastecimentoRepository.findAll();
    }

    public Optional<Abastecimento> buscarPorId(Long id) {
        return abastecimentoRepository.findById(id);
    }

    public Abastecimento salvar(Abastecimento abastecimento) {
        return abastecimentoRepository.save(abastecimento);
    }

    public void deletar(Long id) {
        abastecimentoRepository.deleteById(id);
    }

}
