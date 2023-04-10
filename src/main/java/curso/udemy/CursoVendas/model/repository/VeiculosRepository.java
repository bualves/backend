package curso.udemy.CursoVendas.model.repository;

import curso.udemy.CursoVendas.model.entity.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculosRepository extends JpaRepository<Veiculos, Integer> {
}
