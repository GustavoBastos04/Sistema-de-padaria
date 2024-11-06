package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.ItemEstoqueDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name = "item_estoque")
@Table(name = "item_estoque")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_item")
public class ItemEstoque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item;

    public ItemEstoque(ItemEstoqueDTO newItem){
        this.id_item = newItem.id_item();
    }
}
