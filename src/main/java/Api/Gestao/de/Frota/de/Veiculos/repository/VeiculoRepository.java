package Api.Gestao.de.Frota.de.Veiculos.repository;

import Api.Gestao.de.Frota.de.Veiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
