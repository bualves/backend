package curso.udemy.CursoVendas.model.repository;

import curso.udemy.CursoVendas.model.entity.Frete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreteRepository extends JpaRepository<Frete, Integer>  {
}
