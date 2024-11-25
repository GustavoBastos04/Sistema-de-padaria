package com.example.bakery.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "fornece_ingrediente")
@Table(name = "fornece_ingrediente")
@NoArgsConstructor
@AllArgsConstructor
public class ForneceIngrediente {
    @Id
    private String fornecedor_cnpj;
    private Long id_ingrediente;
    private Long quantidade;
    private BigDecimal preco;
}
