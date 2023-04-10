package curso.udemy.CursoVendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import curso.udemy.CursoVendas.model.entity.Cliente;
import curso.udemy.CursoVendas.model.repository.ClienteRepository;

@SpringBootApplication
public class ClienteApplication {

	@Bean
	public CommandLineRunner run (@Autowired ClienteRepository repository)
	{
		return args -> {
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}

}
