package com.example.bakery.dtos.fornecedor;

public record FornecedorRequestDTO(String cnpj,String nome,
                                   String telefone, String email, String logradouro,
                                   String numero, String cep, String cidade, String uf) {
}
