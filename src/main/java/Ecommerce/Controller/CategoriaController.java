package Ecommerce.Controller;
import java.util.List; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import Ecommerce.Model.Categoria; import Ecommerce.Service.CategoriaService;
@RestController @RequestMapping("/categorias") @CrossOrigin
public class CategoriaController{
 @Autowired private CategoriaService service;
 @GetMapping public ResponseEntity<List<Categoria>> getAll(){return ResponseEntity.ok(service.listar());}
 @GetMapping("/buscar/{descricao}") public ResponseEntity<List<Categoria>> buscar(@PathVariable String descricao){return ResponseEntity.ok(service.buscar(descricao));}
 @PostMapping public ResponseEntity<Categoria> post(@RequestBody Categoria categoria){return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(categoria));}
 @PutMapping public ResponseEntity<Categoria> put(@RequestBody Categoria categoria){return ResponseEntity.ok(service.atualizar(categoria));}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable long id){service.deletar(id); return ResponseEntity.noContent().build();}
}
