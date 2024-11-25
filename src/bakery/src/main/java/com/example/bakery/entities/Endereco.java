package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.ClienteRequestDTO;
import com.example.bakery.dtos.entitydtos.FornecedorRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Setter
@Getter
@Entity(name="endereco")
@Table(name="endereco")
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    private String cep;
    private String logradouro;
    private String cidade;
    private String uf;

    public Endereco(ClienteRequestDTO clienteRequestDTO){
        this.cep = clienteRequestDTO.cep();
        this.logradouro = clienteRequestDTO.logradouro();
        this.cidade = clienteRequestDTO.cidade();
        this.uf = clienteRequestDTO.uf();
    }
    public Endereco(FornecedorRequestDTO fornecedorRequestDTO){
        this.cep = fornecedorRequestDTO.cep();
        this.logradouro = fornecedorRequestDTO.logradouro();
        this.cidade = fornecedorRequestDTO.cidade();
        this.uf = fornecedorRequestDTO.uf();
    }
}
