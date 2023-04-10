package curso.udemy.CursoVendas.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "motoristas")
public class Motoristas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nomeMotorista", nullable = false, length = 150)
    @NotEmpty(message = "{campo.nomeMotorista.obrigatorio}")
    private String nome;

    @Column(name = "cpfMotorista",nullable = false, length = 11)
    @NotNull(message = "{campo.cpfMotorista.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "telefoneMotorista", nullable = false)
    @NotNull(message = "{campo.telefoneMotorista.obrigatorio}")
    private String telefoneMotorista;

    @Column(name = "telefoneSecundarioMotorista")
    private String telefoneSecundarioMotorista;

    @Column(name = "categoriaCNH", nullable = false)
    private String categoriaCNH;

    @Column(name = "numeroCNH", nullable = false)
    private String numeroCNH;

    @Column(name = "usuarioLogado")
    private String usuarioLogado;

}
