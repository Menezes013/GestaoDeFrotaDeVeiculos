package Api.Gestao.de.Frota.de.Veiculos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(title = "Api Gestão de frota", version = "1.0", description = "Documentação dos endpoints do sistema gestão de frota"),
		servers = @Server(url = "/", description = "Servidor local")
)
@SpringBootApplication
public class GestaoDeFrotaDeVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeFrotaDeVeiculosApplication.class, args);
	}

}
