package curso.udemy.CursoVendas.rest;

import curso.udemy.CursoVendas.model.entity.Motoristas;
import curso.udemy.CursoVendas.model.repository.MotoristasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/motoristas")
public class MotoristasController
{

    private final MotoristasRepository repository;

    @Autowired
    public MotoristasController(MotoristasRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Motoristas salvar(@Valid @RequestBody Motoristas motoristas)
    {
        return repository.save(motoristas);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id)
    {
        repository
                .findById(id)
                .map(motoristas -> {
                    repository.delete(motoristas);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motorista não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id,@Valid @RequestBody Motoristas motoristasAtualizados)
    {
        repository
                .findById(id)
                .map(motoristas -> {
                    motoristasAtualizados.setId(motoristas.getId());
                    return repository.save(motoristasAtualizados);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motorista não encontrado"));
    }

    @GetMapping
    public List<Motoristas> obterPorUsuarios()
    {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Motoristas acharPorIdMotorista(@PathVariable Integer id)
    {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Motorista não encontrado"));
    }


}
