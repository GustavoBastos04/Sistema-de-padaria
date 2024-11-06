package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.fornecedor.FornecedorRequestDTO;
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
@EqualsAndHashCode(of = "cpnj")
public class Fornecedor {

    @Id
    private String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String uf;

    public Fornecedor(FornecedorRequestDTO newSupplier){
        this.cnpj = newSupplier.cnpj();
        this.nome = newSupplier.nome();
        this.telefone = newSupplier.telefone();
        this.email = newSupplier.email();
        this.logradouro = newSupplier.logradouro();
        this.numero = newSupplier.numero();
        this.cep = newSupplier.cep();
        this.cidade = newSupplier.cidade();
        this.uf = newSupplier.uf();
    }
}
