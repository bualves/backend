package curso.udemy.CursoVendas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import curso.udemy.CursoVendas.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>
{

}
