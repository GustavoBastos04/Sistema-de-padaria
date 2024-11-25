package com.example.bakery.dtos.entitydtos;

public record ClienteRequestDTO(String cpf,String nome, String tipo_de_assinatura,
                                String telefone, String email, String logradouro,
                                String cep, String numero, String cidade, String uf) {
}
