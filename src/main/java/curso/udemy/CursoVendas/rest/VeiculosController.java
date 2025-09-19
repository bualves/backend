package curso.udemy.CursoVendas.rest;

import curso.udemy.CursoVendas.model.entity.Veiculos;
import curso.udemy.CursoVendas.model.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculosController {

    private VeiculosRepository repository;

    @Autowired
    public VeiculosController(VeiculosRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculos salvar(@Valid @RequestBody Veiculos veiculos, Authentication authentication) {
        String usuarioLogado = authentication.getName();
        veiculos.setUsuarioLogado(usuarioLogado);
        return repository.save(veiculos);
    }

    @GetMapping
    public List<Veiculos> obterPorUsuarios(Authentication authentication) {
        String usuarioLogado = authentication.getName();
        return repository.findByUsuarioLogado(usuarioLogado);
    }

    @GetMapping("{id}")
    public Veiculos acharPorIdVeiculo(@PathVariable Integer id, Authentication authentication) {
        String usuarioLogado = authentication.getName();
        return repository.findByIdAndUsuarioLogado(id, usuarioLogado)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @Valid @RequestBody Veiculos veiculosAtualizados, Authentication authentication) {
        String usuarioLogado = authentication.getName();

        repository.findByIdAndUsuarioLogado(id, usuarioLogado)
                .map(veiculos -> {
                    veiculosAtualizados.setId(veiculos.getId());
                    veiculosAtualizados.setUsuarioLogado(usuarioLogado);
                    return repository.save(veiculosAtualizados);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id, Authentication authentication) {
        String usuarioLogado = authentication.getName();

        repository.findByIdAndUsuarioLogado(id, usuarioLogado)
                .map(veiculos -> {
                    repository.delete(veiculos);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));
    }
}