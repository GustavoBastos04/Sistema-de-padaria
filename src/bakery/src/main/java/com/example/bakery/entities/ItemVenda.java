package com.example.bakery.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "item_venda")
@Table(name = "item_venda")
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenda {
    @Id
    private Long id_produto;
    private Long id_venda;
}
