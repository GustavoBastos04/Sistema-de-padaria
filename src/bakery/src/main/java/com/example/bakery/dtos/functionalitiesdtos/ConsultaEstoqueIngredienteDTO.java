package com.example.bakery.dtos.functionalitiesdtos;

import java.sql.Date;

public interface ConsultaEstoqueIngredienteDTO {
    String getNome();
    Integer getQuantidade();
    Date getData_validade();
}
