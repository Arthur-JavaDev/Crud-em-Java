package com.ecommerce.dto;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
    String nome,
    String descricao,
    BigDecimal preco,
    int estoque,
    String foto,
    Long categoriaId
) {}