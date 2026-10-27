package Ecommerce.Service;
import java.util.List; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service;
import Ecommerce.Model.Produto; import Ecommerce.Repository.ProdutoRepository;
@Service public class ProdutoService{
 @Autowired private ProdutoRepository repository;
 public List<Produto> listar(){return repository.findAll();}
 public Produto cadastrar(Produto produto){return repository.save(produto);}
 public Produto atualizar(Produto produto){return repository.save(produto);}
 public void deletar(long id){repository.deleteById(id);}
 public List<Produto> buscarPorNome(String nome){return repository.findByNomeContainingIgnoreCase(nome);}
 public List<Produto> buscarPorCategoria(long id){return repository.findByCategoriaId(id);}
}
