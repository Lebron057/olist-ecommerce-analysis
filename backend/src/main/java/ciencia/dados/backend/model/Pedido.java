package ciencia.dados.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos_simulados")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double precoProduto;
    private Double valorFrete;
    private String estadoCliente;
    private Integer compraFimSemana;
    private Double previsaoEntregaDias;

    // Construtor vazio obrigatório para o JPA
    public Pedido() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getPrecoProduto() { return precoProduto; }
    public void setPrecoProduto(Double precoProduto) { this.precoProduto = precoProduto; }

    public Double getValorFrete() { return valorFrete; }
    public void setValorFrete(Double valorFrete) { this.valorFrete = valorFrete; }

    public String getEstadoCliente() { return estadoCliente; }
    public void setEstadoCliente(String estadoCliente) { this.estadoCliente = estadoCliente; }

    public Integer getCompraFimSemana() { return compraFimSemana; }
    public void setCompraFimSemana(Integer compraFimSemana) { this.compraFimSemana = compraFimSemana; }

    public Double getPrevisaoEntregaDias() { return previsaoEntregaDias; }
    public void setPrevisaoEntregaDias(Double previsaoEntregaDias) { this.previsaoEntregaDias = previsaoEntregaDias; }
}