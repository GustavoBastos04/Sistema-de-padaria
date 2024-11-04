package com.example.bakery.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "cliente")
@Entity(name = "cliente")
public class Cliente {
    @Id
    private String cpf;
    private String nome;
    private String tipo_de_assinatura;
    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String uf;

    public Cliente() {
    }
}
