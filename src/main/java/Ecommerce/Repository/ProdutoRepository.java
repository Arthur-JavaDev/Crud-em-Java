package Ecommerce.Repository;
import java.util.List; import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import Ecommerce.Model.Produto;
@Repository public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    List<Produto> findByCategoriaId(long categoriaId);
}
