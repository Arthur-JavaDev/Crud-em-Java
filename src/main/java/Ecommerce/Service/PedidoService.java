package Ecommerce.Service;

import java.math.BigDecimal; import java.util.ArrayList; import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import Ecommerce.Model.*; import Ecommerce.Repository.*;

@Service public class PedidoService{
 @Autowired private PedidoRepository pedidoRepository; @Autowired private ProdutoRepository produtoRepository; @Autowired private UsuarioRepository usuarioRepository;
 @Transactional public Pedido criar(Pedido pedido){
  if(pedido.getUsuario()==null || pedido.getUsuario().getId()==0) throw new IllegalArgumentException("Informe o usuario do pedido.");
  Usuario usuario=usuarioRepository.findById(pedido.getUsuario().getId()).orElseThrow(()->new IllegalArgumentException("Usuario nao encontrado."));
  if(pedido.getItens()==null || pedido.getItens().isEmpty()) throw new IllegalArgumentException("O pedido precisa ter itens.");
  List<ItemPedido> itens=new ArrayList<>(); BigDecimal total=BigDecimal.ZERO;
  for(ItemPedido item: pedido.getItens()){
   if(item.getQuantidade()<=0) throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
   if(item.getProduto()==null || item.getProduto().getId()==0) throw new IllegalArgumentException("Informe o produto do item.");
   Produto produto=produtoRepository.findById(item.getProduto().getId()).orElseThrow(()->new IllegalArgumentException("Produto nao encontrado."));
   if(produto.getEstoque()<item.getQuantidade()) throw new IllegalArgumentException("Estoque insuficiente para: "+produto.getNome());
   produto.setEstoque(produto.getEstoque()-item.getQuantidade()); produtoRepository.save(produto);
   item.setProduto(produto); item.setPrecoUnitario(produto.getPreco()); item.setPedido(pedido); itens.add(item);
   total=total.add(produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade())));
  }
  pedido.setUsuario(usuario); pedido.setItens(itens); pedido.setValorTotal(total); if(pedido.getStatus()==null) pedido.setStatus("RECEBIDO");
  return pedidoRepository.save(pedido);
 }
 public List<Pedido> listar(){return pedidoRepository.findAll();}
 public List<Pedido> listarPorUsuario(long usuarioId){return pedidoRepository.findByUsuarioId(usuarioId);}
 public Pedido buscar(long id){return pedidoRepository.findById(id).orElse(null);}
 public Pedido atualizarStatus(long id,String status){Pedido pedido=pedidoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Pedido nao encontrado.")); pedido.setStatus(status); return pedidoRepository.save(pedido);}
}
