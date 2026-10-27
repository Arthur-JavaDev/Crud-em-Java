package Ecommerce.Service;

import java.nio.charset.Charset;
import java.util.Optional;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import Ecommerce.Model.Usuario;
import Ecommerce.Model.UsuarioLogin;
import Ecommerce.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired private UsuarioRepository repository;

    public Usuario cadastrarUsuario(Usuario usuario){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        if(usuario.getTipo()==null || usuario.getTipo().isBlank()) usuario.setTipo("CLIENTE");
        return repository.save(usuario);
    }

    public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
        if(usuario.isPresent() && encoder.matches(user.get().getSenha(), usuario.get().getSenha())){
            String auth = user.get().getUsuario()+":"+user.get().getSenha();
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
            user.get().setToken("Basic "+new String(encodedAuth));
            user.get().setId(usuario.get().getId());
            user.get().setNome(usuario.get().getNome());
            user.get().setFoto(usuario.get().getFoto());
            user.get().setTipo(usuario.get().getTipo());
            user.get().setSenha(null);
            return user;
        }
        return Optional.empty();
    }
}
