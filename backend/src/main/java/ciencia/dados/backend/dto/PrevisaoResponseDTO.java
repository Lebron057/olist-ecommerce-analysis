package ciencia.dados.backend.dto;

public class PrevisaoResponseDTO {

    private String status;
    private Double previsao_entrega_dias;
    private String mensagem;

    public PrevisaoResponseDTO() {}

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getPrevisao_entrega_dias() { return previsao_entrega_dias; }
    public void setPrevisao_entrega_dias(Double previsao_entrega_dias) { this.previsao_entrega_dias = previsao_entrega_dias; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}