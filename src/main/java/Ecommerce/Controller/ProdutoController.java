package Ecommerce.Controller;
import java.util.List; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import Ecommerce.Model.Produto; import Ecommerce.Service.ProdutoService;
@RestController @RequestMapping("/produtos") @CrossOrigin
public class ProdutoController{
 @Autowired private ProdutoService service;
 @GetMapping public ResponseEntity<List<Produto>> getAll(){return ResponseEntity.ok(service.listar());}
 @GetMapping("/{id}") public ResponseEntity<Produto> getById(@PathVariable long id){return service.listar().stream().filter(p->p.getId()==id).findFirst().map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
 @GetMapping("/nome/{nome}") public ResponseEntity<List<Produto>> buscarNome(@PathVariable String nome){return ResponseEntity.ok(service.buscarPorNome(nome));}
 @GetMapping("/categoria/{id}") public ResponseEntity<List<Produto>> buscarCategoria(@PathVariable long id){return ResponseEntity.ok(service.buscarPorCategoria(id));}
 @PostMapping public ResponseEntity<Produto> post(@RequestBody Produto produto){return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(produto));}
 @PutMapping public ResponseEntity<Produto> put(@RequestBody Produto produto){return ResponseEntity.ok(service.atualizar(produto));}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable long id){service.deletar(id); return ResponseEntity.noContent().build();}
}
