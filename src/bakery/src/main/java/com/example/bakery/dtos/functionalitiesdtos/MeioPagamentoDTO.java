package com.example.bakery.dtos.functionalitiesdtos;

import java.math.BigDecimal;

public interface MeioPagamentoDTO {
    String getTipo();
    BigDecimal getQtd_vendas();
    BigDecimal getValor_total();
}
