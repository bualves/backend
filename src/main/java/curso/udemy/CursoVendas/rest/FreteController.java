package curso.udemy.CursoVendas.rest;

import curso.udemy.CursoVendas.model.entity.Frete;
import curso.udemy.CursoVendas.model.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/frete")
public class FreteController {

    private final FreteRepository repository;

    @Autowired
    public FreteController(FreteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Frete salvar(@Valid @RequestBody Frete frete, Authentication authentication) {
        String usuarioLogado = authentication.getName();
        frete.setUsuarioLogado(usuarioLogado);
        return repository.save(frete);
    }

    @GetMapping
    public List<Frete> obterPorUsuarios(Authentication authentication) {
        String usuarioLogado = authentication.getName();
        return repository.findByUsuarioLogado(usuarioLogado);
    }

    @GetMapping("{id}")
    public Frete acharPorIdMotorista(@PathVariable Integer id, Authentication authentication) {
        String usuarioLogado = authentication.getName();
        return repository.findByIdAndUsuarioLogado(id, usuarioLogado)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Frete não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Frete freteAtualizado, Authentication authentication) {
        String usuarioLogado = authentication.getName();

        repository.findByIdAndUsuarioLogado(id, usuarioLogado)
                .map(frete -> {
                    freteAtualizado.setId(frete.getId());
                    freteAtualizado.setUsuarioLogado(usuarioLogado);
                    return repository.save(freteAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Frete não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id, Authentication authentication) {
        String usuarioLogado = authentication.getName();

        repository.findByIdAndUsuarioLogado(id, usuarioLogado)
                .map(frete -> {
                    repository.delete(frete);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Frete não encontrado"));
    }
}