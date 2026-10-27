package Ecommerce.Controller;
import java.util.List; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
import Ecommerce.Model.Pedido; import Ecommerce.Service.PedidoService;
@RestController @RequestMapping("/pedidos") @CrossOrigin
public class PedidoController{
 @Autowired private PedidoService service;
 @GetMapping public ResponseEntity<List<Pedido>> getAll(){return ResponseEntity.ok(service.listar());}
 @GetMapping("/{id}") public ResponseEntity<Pedido> getById(@PathVariable long id){Pedido pedido=service.buscar(id); return pedido==null?ResponseEntity.notFound().build():ResponseEntity.ok(pedido);}
 @GetMapping("/usuario/{id}") public ResponseEntity<List<Pedido>> getByUsuario(@PathVariable long id){return ResponseEntity.ok(service.listarPorUsuario(id));}
 @PostMapping public ResponseEntity<Pedido> post(@RequestBody Pedido pedido){try{return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(pedido));}catch(IllegalArgumentException e){return ResponseEntity.badRequest().build();}}
 @PutMapping("/{id}/status") public ResponseEntity<Pedido> status(@PathVariable long id,@RequestParam String valor){try{return ResponseEntity.ok(service.atualizarStatus(id,valor));}catch(IllegalArgumentException e){return ResponseEntity.notFound().build();}}
}
