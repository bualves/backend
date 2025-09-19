package curso.udemy.CursoVendas.model.repository;

import curso.udemy.CursoVendas.model.entity.Frete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FreteRepository extends JpaRepository<Frete, Integer> {
    List<Frete> findByUsuarioLogado(String usuarioLogado);
    Optional<Frete> findByIdAndUsuarioLogado(Integer id, String usuarioLogado);
}