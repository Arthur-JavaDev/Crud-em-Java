package Ecommerce.Repository;
import java.util.List; import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import Ecommerce.Model.Pedido;
@Repository public interface PedidoRepository extends JpaRepository<Pedido,Long>{
    List<Pedido> findByUsuarioId(long usuarioId);
}
