package Ecommerce.Model;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int estoque;
    private String foto;

    @ManyToOne
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;

    public long getId(){return id;} public void setId(long id){this.id=id;}
    public String getNome(){return nome;} public void setNome(String nome){this.nome=nome;}
    public String getDescricao(){return descricao;} public void setDescricao(String descricao){this.descricao=descricao;}
    public BigDecimal getPreco(){return preco;} public void setPreco(BigDecimal preco){this.preco=preco;}
    public int getEstoque(){return estoque;} public void setEstoque(int estoque){this.estoque=estoque;}
    public String getFoto(){return foto;} public void setFoto(String foto){this.foto=foto;}
    public Categoria getCategoria(){return categoria;} public void setCategoria(Categoria categoria){this.categoria=categoria;}
}
