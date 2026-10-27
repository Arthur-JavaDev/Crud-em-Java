package Ecommerce.Model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String usuario;
    private String foto;
    private String tipo;
    private String senha;

    @OneToMany(mappedBy="usuario", cascade=CascadeType.REMOVE)
    @JsonIgnoreProperties("usuario")
    private List<Pedido> pedidos;

    public long getId(){return id;} public void setId(long id){this.id=id;}
    public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
    public String getUsuario(){return usuario;} public void setUsuario(String usuario){this.usuario=usuario;}
    public String getFoto(){return foto;} public void setFoto(String foto){this.foto=foto;}
    public String getTipo(){return tipo;} public void setTipo(String tipo){this.tipo=tipo;}
    public String getSenha(){return senha;} public void setSenha(String senha){this.senha=senha;}
    public List<Pedido> getPedidos(){return pedidos;} public void setPedidos(List<Pedido> pedidos){this.pedidos=pedidos;}
}
