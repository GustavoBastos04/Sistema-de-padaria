package com.example.bakery.entities;

import com.example.bakery.dtos.ProdutoDTO;
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
    private Long quantidade;
    private Long estoque_id_item;

    public Produto(ProdutoDTO produto){
        this.id_produto = produto.id_produto();
        this.nome = produto.nome();
        this.valor = produto.valor();
        this.quantidade = produto.quantidade();
        this.estoque_id_item = produto.estoque_id_item();
    }
}
