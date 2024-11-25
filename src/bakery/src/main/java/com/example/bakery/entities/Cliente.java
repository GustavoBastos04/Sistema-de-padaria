package com.example.bakery.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Setter
@Getter
@Table(name = "cliente")
@Entity(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class Cliente {
    @Id
    private String cpf;
    private String nome;
    private String tipo_de_assinatura;
    private String telefone;
    private String email;
    private String cep;
    private String numero;
}
