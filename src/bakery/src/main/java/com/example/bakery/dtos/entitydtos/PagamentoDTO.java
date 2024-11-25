package com.example.bakery.dtos.entitydtos;

import com.example.bakery.entities.Pagamento;

public record PagamentoDTO(String cliente_cpf, Long id_venda, String tipo) {
    public PagamentoDTO(Pagamento pagamento){
        this(pagamento.getCliente_cpf(), pagamento.getId_venda(), pagamento.getTipo());
    }
}
