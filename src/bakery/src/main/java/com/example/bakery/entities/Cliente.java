package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.cliente.ClienteRequestDTO;
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
    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String uf;

    public Cliente(ClienteRequestDTO newClient){
        this.cpf = newClient.cpf();
        this.nome = newClient.nome();
        this.tipo_de_assinatura = newClient.tipo_de_assinatura();
        this.telefone = newClient.telefone();
        this.email = newClient.email();
        this.logradouro = newClient.logradouro();
        this.numero = newClient.numero();
        this.cep = newClient.cep();
        this.cidade = newClient.cidade();
        this.uf = newClient.uf();
    }
}
