package Ecommerce.Repository;
import java.util.List; import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.stereotype.Repository;
import Ecommerce.Model.Usuario;
@Repository public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
    Optional<Usuario> findByUsuario(String usuario);
}
