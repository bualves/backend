package curso.udemy.CursoVendas.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "veiculos")
public class Veiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "placa", nullable = false)
    private String placa;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "usuarioLogado")
    private String usuarioLogado;

}
