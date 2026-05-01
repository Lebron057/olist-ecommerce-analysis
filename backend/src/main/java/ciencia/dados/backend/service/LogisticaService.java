package ciencia.dados.backend.service;

import ciencia.dados.backend.dto.PrevisaoRequestDTO;
import ciencia.dados.backend.dto.PrevisaoResponseDTO;
import ciencia.dados.backend.model.Pedido;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class LogisticaService {

    // O endereço da sua API de Machine Learning em Python
    private final String PYTHON_API_URL = "http://localhost:8000/prever";
    private final RestTemplate restTemplate;

    public LogisticaService() {
        this.restTemplate = new RestTemplate();
    }

    public Pedido processarNovoPedido(Pedido pedido) {

        // 1. Montamos o "pacote" (JSON) para enviar para a IA
        PrevisaoRequestDTO request = new PrevisaoRequestDTO();
        request.setPreco_produto(pedido.getPrecoProduto());
        request.setValor_frete(pedido.getValorFrete());
        request.setEstado_cliente(pedido.getEstadoCliente());
        request.setCompra_fim_semana(pedido.getCompraFimSemana());

        try {
            // 2. Fazemos a requisição POST para o Python usando o RestTemplate
            ResponseEntity<PrevisaoResponseDTO> response = restTemplate.postForEntity(
                    PYTHON_API_URL,
                    request,
                    PrevisaoResponseDTO.class
            );

            // 3. Pegamos a resposta da Inteligência Artificial
            if (response.getBody() != null) {
                Double diasPrevistos = response.getBody().getPrevisao_entrega_dias();

                // 4. Inserimos a previsão dentro do nosso pedido
                pedido.setPrevisaoEntregaDias(diasPrevistos);

                System.out.println("SUCESSO: A IA previu " + diasPrevistos + " dias para entrega!");
            }

        } catch (Exception e) {
            System.err.println("Erro ao comunicar com a API Python: " + e.getMessage());
            // Em um sistema real, colocaríamos um valor padrão ou lançaríamos uma exceção
            pedido.setPrevisaoEntregaDias(0.0);
        }

        return pedido;
    }
}