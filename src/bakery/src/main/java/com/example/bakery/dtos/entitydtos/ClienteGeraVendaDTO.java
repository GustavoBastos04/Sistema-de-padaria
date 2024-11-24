package com.example.bakery.dtos.entitydtos;

import com.example.bakery.entities.ClienteGeraVenda;

public record ClienteGeraVendaDTO(String cliente_cpf, Long venda_id_venda) {
    public ClienteGeraVendaDTO(ClienteGeraVenda clienteGeraVenda){
        this(clienteGeraVenda.getCliente_cpf(), clienteGeraVenda.getVenda_id_venda());
    }
}
