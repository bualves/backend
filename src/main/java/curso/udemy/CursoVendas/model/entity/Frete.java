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

    @Column(name = "contratanteFrete")
    private String contratanteFrete;

    @Column(name = "cidadeOrigem")
    private String cidadeOrigem;

    @Column(name = "cidadeDestino")
    private String cidadeDestino;

    @Column(name = "estado")
    private String estado;

    @Column(name = "valorTotal")
    private String valorTotal;

    @Column(name = "valorPago")
    private String valorPago;

    @Column(name = "statusFrete")
    private String statusFrete;

    @Column(name = "statusPagamento")
    private String statusPagamento;

    @Column(name = "dataInicio")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataInicio;

    @Column(name = "dataFinal")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataFinal;

    @Column(name = "usuarioLogado")
    private String usuarioLogado;

    @Column(name = "valorFinal")
    private String valorFinal;
}
