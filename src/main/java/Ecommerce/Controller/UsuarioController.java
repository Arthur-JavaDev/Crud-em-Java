package Ecommerce.Controller;

import java.util.List; import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.http.HttpStatus; import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*;
import Ecommerce.Model.Usuario; import Ecommerce.Model.UsuarioLogin; import Ecommerce.Repository.UsuarioRepository; import Ecommerce.Service.UsuarioService;

@RestController @RequestMapping("/usuarios") @CrossOrigin
public class UsuarioController{
 @Autowired private UsuarioRepository repository; @Autowired private UsuarioService service;
 @GetMapping public ResponseEntity<List<Usuario>> getAll(){return ResponseEntity.ok(repository.findAll());}
 @GetMapping("/{id}") public ResponseEntity<Usuario> getById(@PathVariable long id){return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
 @GetMapping("/nome/{nome}") public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome){return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));}
 @PostMapping public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarUsuario(usuario));}
 @PutMapping public ResponseEntity<Usuario> put(@RequestBody Usuario usuario){return ResponseEntity.ok(repository.save(usuario));}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable long id){if(!repository.existsById(id)) return ResponseEntity.notFound().build(); repository.deleteById(id); return ResponseEntity.noContent().build();}
 @PostMapping("/logar") public ResponseEntity<UsuarioLogin> logar(@RequestBody UsuarioLogin login){Optional<UsuarioLogin> resultado=service.Logar(Optional.of(login)); return resultado.isPresent()?ResponseEntity.ok(resultado.get()):ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();}
}
