package com.example.bakery.dtos.functionalitiesdtos;

import java.math.BigDecimal;

public interface LucroProdutoDTO {
    Long getId_produto();
    String getNome();
    BigDecimal getReceita();
    BigDecimal getCusto();
    BigDecimal getLucro();
}
