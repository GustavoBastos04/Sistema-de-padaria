package com.example.bakery.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity(name = "fornecedor")
@Table(name = "fornecedor")
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {

    @Id
    private String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String cep;
    private String numero;

}
