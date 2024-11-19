package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.ForneceItemEstoqueDTO;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "fornece_ingrediente")
@Table(name = "fornece_ingrediente")
@NoArgsConstructor
@AllArgsConstructor
public class ForneceItemEstoque {
    @Id
    private String fornecedor_cnpj;
    private Long id_ingrediente;
    private Long quantidade;
    private BigDecimal preco;

    public ForneceItemEstoque(ForneceItemEstoqueDTO forneceItemEstoque){
        this.fornecedor_cnpj = forneceItemEstoque.fornecedor_cnpj();
        this.id_ingrediente = forneceItemEstoque.id_ingrediente();
        this.quantidade = forneceItemEstoque.quantidade();
        this.preco = forneceItemEstoque.preco();
    }
}
