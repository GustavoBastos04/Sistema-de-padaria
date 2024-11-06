package com.example.bakery.dtos.entitydtos;

import com.example.bakery.entities.Pagamento;

public record PagamentoDTO(String cliente_cpf, String tipo) {
    public PagamentoDTO(Pagamento pagamento){
        this(pagamento.getCliente_cpf(), pagamento.getTipo());
    }
}
