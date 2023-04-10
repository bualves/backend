package curso.udemy.CursoVendas.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "login")//Nome da coluna no banco de dados
    @NotEmpty(message = "{campo.usuario.obrigatorio}")
    private String username;

    @Column(name = "senha")//Nome da coluna no banco de dados
    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String password;
}
