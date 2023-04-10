package curso.udemy.CursoVendas.rest;

import curso.udemy.CursoVendas.model.entity.Motoristas;
import curso.udemy.CursoVendas.model.entity.Veiculos;
import curso.udemy.CursoVendas.model.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculosController {

    private VeiculosRepository repository;

    @Autowired
    public VeiculosController(VeiculosRepository repository)
    {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculos salvar(@Valid @RequestBody Veiculos veiculos)
    {
        return repository.save(veiculos);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id)
    {
        repository
                .findById(id)
                .map(veiculos -> {
                    repository.delete(veiculos);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motorista não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id,@Valid @RequestBody  Veiculos veiculosAtualizados)
    {
        repository
                .findById(id)
                .map(veiculos -> {
                    veiculosAtualizados.setId(veiculos.getId());
                    return repository.save(veiculosAtualizados);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculos não encontrado"));
    }

    @GetMapping
    public List<Veiculos> obterPorUsuarios()
    {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Veiculos acharPorIdVeiculo(@PathVariable Integer id)
    {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motorista não encontrado"));
    }
}
