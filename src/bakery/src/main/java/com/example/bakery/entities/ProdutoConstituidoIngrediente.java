package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.ProdutoConstIngredienteDTO;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity(name = "produto_constituido_ingrediente")
@Table(name = "produto_constituido_ingrediente")
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoConstituidoIngrediente {
    @Id
    private Long id_produto;
    private Long id_ingrediente;
    @Column
    private Long quantidade;

    public ProdutoConstituidoIngrediente(ProdutoConstIngredienteDTO prodConstIngredDto){
        this.id_produto = prodConstIngredDto.id_produto();
        this.id_ingrediente = prodConstIngredDto.id_ingrediente();
        this.quantidade = prodConstIngredDto.quantidade();
    }
}
