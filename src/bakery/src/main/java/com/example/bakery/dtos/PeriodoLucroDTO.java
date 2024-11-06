package com.example.bakery.dtos;

import com.example.bakery.entities.Venda;

import java.sql.Date;

public class PeriodoLucroDTO {
    private Date dataInicial;
    private Date dataFinal;
    private Long idVenda;
    private Double receita;
    private Double custo;
    private Double lucro;
}