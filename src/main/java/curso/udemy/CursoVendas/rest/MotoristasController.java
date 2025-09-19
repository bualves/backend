package curso.udemy.CursoVendas.rest;

import curso.udemy.CursoVendas.model.entity.Motoristas;
import curso.udemy.CursoVendas.model.repository.MotoristasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/motoristas")
public class MotoristasController {

    private final MotoristasRepository repository;

    @Autowired
    public MotoristasController(MotoristasRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Motoristas salvar(@Valid @RequestBody Motoristas motoristas, Authentication authentication) {
        String usuarioLogado = authentication.getName(); // CAPTURA USUÁRIO
        motoristas.setUsuarioLogado(usuarioLogado); // DEFINE AUTOMATICAMENTE
        return repository.save(motoristas);
    }

    @GetMapping
    public List<Motoristas> obterPorUsuarios(Authentication authentication) {
        String usuarioLogado = authentication.getName(); // CAPTURA USUÁRIO
        return repository.findByUsuarioLogado(usuarioLogado); // FILTRA POR USUÁRIO
    }

    @GetMapping("{id}")
    public Motoristas acharPorIdMotorista(@PathVariable Integer id, Authentication authentication) {
        String usuarioLogado = authentication.getName(); // CAPTURA USUÁRIO
        return repository.findByIdAndUsuarioLogado(id, usuarioLogado)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motorista não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Motoristas motoristasAtualizados, Authentication authentication) {
        String usuarioLogado = authentication.getName(); // CAPTURA USUÁRIO

        repository.findByIdAndUsuarioLogado(id, usuarioLogado)
                .map(motoristas -> {
                    motoristasAtualizados.setId(motoristas.getId());
                    motoristasAtualizados.setUsuarioLogado(usuarioLogado); // GARANTE QUE SÓ ATUALIZA PRÓPRIOS DADOS
                    return repository.save(motoristasAtualizados);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motorista não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id, Authentication authentication) {
        String usuarioLogado = authentication.getName(); // CAPTURA USUÁRIO

        repository.findByIdAndUsuarioLogado(id, usuarioLogado)
                .map(motoristas -> {
                    repository.delete(motoristas);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motorista não encontrado"));
    }
}