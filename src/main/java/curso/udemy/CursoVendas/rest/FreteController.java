package curso.udemy.CursoVendas.rest;
import curso.udemy.CursoVendas.model.entity.Frete;
import curso.udemy.CursoVendas.model.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/frete")
public class FreteController
{

    private final FreteRepository repository;

    @Autowired
    public FreteController(FreteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Frete salvar(@Valid @RequestBody Frete frete)
    {
        return repository.save(frete);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id)
    {
        repository
                .findById(id)
                .map(frete -> {
                    repository.delete(frete);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Frete não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id,@Valid @RequestBody Frete freteAtualizado)
    {
        repository
                .findById(id)
                .map(motoristas -> {
                    freteAtualizado.setId(motoristas.getId());
                    return repository.save(freteAtualizado);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Frete não encontrado"));
    }

    @GetMapping
    public List<Frete> obterPorUsuarios()
    {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Frete acharPorIdMotorista(@PathVariable Integer id)
    {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Frete não encontrado"));
    }


}
