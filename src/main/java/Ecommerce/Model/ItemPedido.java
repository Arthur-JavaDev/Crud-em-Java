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
@Table(name="item_pedido")
public class ItemPedido {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private int quantidade;
    private BigDecimal precoUnitario;

    @ManyToOne @JsonIgnoreProperties("itens")
    private Pedido pedido;
    @ManyToOne @JsonIgnoreProperties({"categoria"})
    private Produto produto;

    public long getId(){return id;} public void setId(long id){this.id=id;}
    public int getQuantidade(){return quantidade;} public void setQuantidade(int quantidade){this.quantidade=quantidade;}
    public BigDecimal getPrecoUnitario(){return precoUnitario;} public void setPrecoUnitario(BigDecimal precoUnitario){this.precoUnitario=precoUnitario;}
    public Pedido getPedido(){return pedido;} public void setPedido(Pedido pedido){this.pedido=pedido;}
    public Produto getProduto(){return produto;} public void setProduto(Produto produto){this.produto=produto;}
}
