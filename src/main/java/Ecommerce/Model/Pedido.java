package Ecommerce.Model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="pedido")
public class Pedido {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date data = new Date();
    private String status;
    private BigDecimal valorTotal;

    @ManyToOne @JsonIgnoreProperties("pedidos")
    private Usuario usuario;

    @OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
    @JsonIgnoreProperties("pedido")
    private List<ItemPedido> itens;

    public long getId(){return id;} public void setId(long id){this.id=id;}
    public Date getData(){return data;} public void setData(Date data){this.data=data;}
    public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
    public BigDecimal getValorTotal(){return valorTotal;} public void setValorTotal(BigDecimal valorTotal){this.valorTotal=valorTotal;}
    public Usuario getUsuario(){return usuario;} public void setUsuario(Usuario usuario){this.usuario=usuario;}
    public List<ItemPedido> getItens(){return itens;} public void setItens(List<ItemPedido> itens){this.itens=itens;}
}
