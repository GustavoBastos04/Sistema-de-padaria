package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "produto")
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;
    private String nome;
    private BigDecimal valor;

    public Produto(ProdutoDTO produto){
        this.id_produto = produto.id_produto();
        this.nome = produto.nome();
        this.valor = produto.valor();
    }
}
