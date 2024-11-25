package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.ClienteRequestDTO;
import jakarta.persistence.Column;
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
public class Cliente {
    @Id @Column(name="cpf")
    private String cpf;
    private String nome;
    private String tipo_de_assinatura;
    private String telefone;
    private String email;
    private String cep;
    private String numero;

    public Cliente(ClienteRequestDTO clienteRequestDTO){
        this.cpf = clienteRequestDTO.cpf();
        this.nome = clienteRequestDTO.nome();
        this.tipo_de_assinatura = clienteRequestDTO.tipo_de_assinatura();
        this.telefone = clienteRequestDTO.telefone();
        this.cep = clienteRequestDTO.cep();
        this.email = clienteRequestDTO.email();
        this.numero = clienteRequestDTO.numero();
    }
}
