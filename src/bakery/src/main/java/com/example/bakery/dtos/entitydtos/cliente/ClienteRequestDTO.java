package com.example.bakery.dtos.entitydtos.cliente;

public record ClienteRequestDTO(String cpf,String nome, String tipo_de_assinatura,
                                String telefone, String email, String logradouro,
                                String numero, String cep, String cidade, String uf) {
}
