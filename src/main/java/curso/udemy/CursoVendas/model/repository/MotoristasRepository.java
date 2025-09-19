package curso.udemy.CursoVendas.model.repository;

import curso.udemy.CursoVendas.model.entity.Motoristas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MotoristasRepository extends JpaRepository<Motoristas, Integer> {

    // Buscar motoristas por usuário logado
    List<Motoristas> findByUsuarioLogado(String usuarioLogado);

    // Buscar motorista por ID e usuário logado (para segurança)
    Optional<Motoristas> findByIdAndUsuarioLogado(Integer id, String usuarioLogado);
}