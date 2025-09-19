package curso.udemy.CursoVendas.model.repository;

import curso.udemy.CursoVendas.model.entity.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VeiculosRepository extends JpaRepository<Veiculos, Integer> {
    List<Veiculos> findByUsuarioLogado(String usuarioLogado);
    Optional<Veiculos> findByIdAndUsuarioLogado(Integer id, String usuarioLogado);
}