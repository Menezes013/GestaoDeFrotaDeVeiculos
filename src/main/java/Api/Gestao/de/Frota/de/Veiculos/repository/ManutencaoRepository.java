package Api.Gestao.de.Frota.de.Veiculos.repository;

import Api.Gestao.de.Frota.de.Veiculos.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
