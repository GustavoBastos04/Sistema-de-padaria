package com.example.bakery.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Table(name = "cliente")
@Entity(name = "cliente")
public class Cliente {
    @Id
    private String cpf;
    @Setter
    private String nome;
    @Setter
    private String tipo_de_assinatura;
    @Setter
    private String telefone;
    @Setter
    private String email;
    @Setter
    private String logradouro;
    @Setter
    private String numero;
    @Setter
    private String cep;
    @Setter
    private String cidade;
    @Setter
    private String uf;
}
