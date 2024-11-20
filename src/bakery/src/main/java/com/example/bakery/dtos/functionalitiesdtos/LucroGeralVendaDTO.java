package com.example.bakery.dtos.functionalitiesdtos;

import java.math.BigDecimal;

public interface LucroGeralVendaDTO {
    Long getId_venda();
    BigDecimal getReceita();
    BigDecimal getCusto();
    BigDecimal getLucro();
}
