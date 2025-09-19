package curso.udemy.CursoVendas.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "servicoprestado")  // CORRIGIDO - nome da tabela em minúsculo
public class ServicoPrestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricaoservicoprestado", nullable = false, length = 255)  // CORRIGIDO
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")  // Este está correto
    private Cliente cliente;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data")  // ADICIONADO - especificar o nome da coluna
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
}