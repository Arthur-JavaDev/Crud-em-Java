package Ecommerce.Repository;
import java.util.List; import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import Ecommerce.Model.Categoria;
@Repository public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
    List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
}
