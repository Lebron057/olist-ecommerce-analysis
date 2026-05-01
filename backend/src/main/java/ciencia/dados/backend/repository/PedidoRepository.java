package ciencia.dados.backend.repository;

import ciencia.dados.backend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // O JpaRepository já nos fornece os métodos save(), findAll(), findById(), etc.
}