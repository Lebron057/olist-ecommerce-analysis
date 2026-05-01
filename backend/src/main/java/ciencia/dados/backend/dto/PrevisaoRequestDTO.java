package ciencia.dados.backend.dto;

public class PrevisaoRequestDTO {

    private Double preco_produto;
    private Double valor_frete;
    private String estado_cliente;
    private Integer compra_fim_semana;

    public PrevisaoRequestDTO() {}

    public Double getPreco_produto() { return preco_produto; }
    public void setPreco_produto(Double preco_produto) { this.preco_produto = preco_produto; }

    public Double getValor_frete() { return valor_frete; }
    public void setValor_frete(Double valor_frete) { this.valor_frete = valor_frete; }

    public String getEstado_cliente() { return estado_cliente; }
    public void setEstado_cliente(String estado_cliente) { this.estado_cliente = estado_cliente; }

    public Integer getCompra_fim_semana() { return compra_fim_semana; }
    public void setCompra_fim_semana(Integer compra_fim_semana) { this.compra_fim_semana = compra_fim_semana; }
}

