package Ecommerce.Service;
import java.util.List; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service;
import Ecommerce.Model.Categoria; import Ecommerce.Repository.CategoriaRepository;
@Service public class CategoriaService{
 @Autowired private CategoriaRepository repository;
 public List<Categoria> listar(){return repository.findAll();}
 public Categoria cadastrar(Categoria categoria){return repository.save(categoria);}
 public Categoria atualizar(Categoria categoria){return repository.save(categoria);}
 public void deletar(long id){repository.deleteById(id);}
 public List<Categoria> buscar(String descricao){return repository.findAllByDescricaoContainingIgnoreCase(descricao);}
}
