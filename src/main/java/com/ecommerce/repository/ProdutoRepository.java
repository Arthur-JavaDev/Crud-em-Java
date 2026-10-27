package com.ecommerce.repository;

import com.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByAtivoTrue();
    List<Produto> findAllByNomeContainingIgnoreCaseAndAtivoTrue(String nome);
}