package ciencia.dados.backend.controller;

import ciencia.dados.backend.model.Pedido;
import ciencia.dados.backend.repository.PedidoRepository;
import ciencia.dados.backend.service.LogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private LogisticaService logisticaService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping("/checkout")
    public ResponseEntity<Pedido> realizarCheckout(@RequestBody Pedido novoPedido) {

        System.out.println("1. Recebendo novo pedido do cliente...");

        // Envia para o serviço que vai bater na API Python e calcular o frete
        Pedido pedidoComPrevisao = logisticaService.processarNovoPedido(novoPedido);

        System.out.println("2. Salvando pedido no banco de dados MySQL...");

        // Salva o pedido finalizado com a previsão no MySQL
        Pedido pedidoSalvo = pedidoRepository.save(pedidoComPrevisao);

        System.out.println("3. Checkout finalizado com sucesso!");

        // Retorna o pedido completo (com ID e previsão) para quem chamou a API
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }
}
