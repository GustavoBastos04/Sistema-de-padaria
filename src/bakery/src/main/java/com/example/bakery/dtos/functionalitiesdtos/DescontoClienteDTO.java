package com.example.bakery.dtos.functionalitiesdtos;

import java.math.BigDecimal;
public interface DescontoClienteDTO {
    String getNome();
    String getCpf();
    BigDecimal getTotal_gasto();
    BigDecimal getDesconto();
    BigDecimal getTotal_com_desconto();
}
