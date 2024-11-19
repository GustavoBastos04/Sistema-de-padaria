package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.IngredienteDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name = "ingrediente")
@Table(name = "ingrediente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_ingrediente")
public class Ingrediente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ingrediente;
    private String nome;
    private Long estoque_id_item;

    public Ingrediente(IngredienteDTO ingrediente){
        this.id_ingrediente = ingrediente.id_ingrediente();
        this.nome = ingrediente.nome();
        this.estoque_id_item = ingrediente.estoque_id_item();
    }
}
