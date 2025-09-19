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

    @Column(name = "nomemotorista", nullable = false, length = 150)  // CORRIGIDO
    @NotEmpty(message = "{campo.nomeMotorista.obrigatorio}")
    private String nome;

    @Column(name = "cpfmotorista", nullable = false, length = 11)    // CORRIGIDO
    @NotNull(message = "{campo.cpfMotorista.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "telefonemotorista", nullable = false)           // CORRIGIDO
    @NotNull(message = "{campo.telefoneMotorista.obrigatorio}")
    private String telefoneMotorista;

    @Column(name = "telefonesecundariomotorista")                   // CORRIGIDO
    private String telefoneSecundarioMotorista;

    @Column(name = "categoriacnh", nullable = false)               // CORRIGIDO
    private String categoriaCNH;

    @Column(name = "numerocnh", nullable = false)                  // CORRIGIDO
    private String numeroCNH;

    @Column(name = "usuariologado")                                // CORRIGIDO
    private String usuarioLogado;
}