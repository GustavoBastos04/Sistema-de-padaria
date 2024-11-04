package com.example.bakery.dtos;

import com.example.bakery.entities.Cliente;
import com.example.bakery.entities.Venda;

import java.math.BigDecimal;
import java.sql.Date;

public record VendaDTO(Long id_venda, BigDecimal valor, Date data_de_venda) {

    public VendaDTO(Venda venda){
        this(venda.getId_venda(), venda.getValor(), venda.getData_de_venda());
    }

}
