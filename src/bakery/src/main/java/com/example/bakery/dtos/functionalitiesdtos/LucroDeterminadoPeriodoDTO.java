package com.example.bakery.dtos.functionalitiesdtos;

import java.math.BigDecimal;

public interface LucroDeterminadoPeriodoDTO {
    String getData_inicial();
    String getData_final();
    BigDecimal getReceita_total();
    BigDecimal getCusto_total();
    BigDecimal getLucro_total();
}
