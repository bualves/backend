package curso.udemy.CursoVendas.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "frete")
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "motorista", nullable = false, length = 150)
    private String motorista;

    @Column(name = "veiculo")
    private String veiculo;

    @Column(name = "contratantefrete")  // CORRIGIDO
    private String contratanteFrete;

    @Column(name = "cidadeorigem")      // CORRIGIDO
    private String cidadeOrigem;

    @Column(name = "cidadedestino")     // CORRIGIDO
    private String cidadeDestino;

    @Column(name = "estado")
    private String estado;

    @Column(name = "valortotal")        // CORRIGIDO
    private String valorTotal;

    @Column(name = "valorpago")         // CORRIGIDO
    private String valorPago;

    @Column(name = "statusfrete")       // CORRIGIDO
    private String statusFrete;

    @Column(name = "statuspagamento")   // CORRIGIDO
    private String statusPagamento;

    @Column(name = "datainicio")        // CORRIGIDO
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataInicio;

    @Column(name = "datafinal")         // CORRIGIDO
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataFinal;

    @Column(name = "usuariologado")     // CORRIGIDO
    private String usuarioLogado;

    @Column(name = "valorfinal")        // CORRIGIDO
    private String valorFinal;
}