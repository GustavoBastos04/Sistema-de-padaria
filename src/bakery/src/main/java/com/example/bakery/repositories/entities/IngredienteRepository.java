package com.example.bakery.repositories.entities;

import com.example.bakery.dtos.functionalitiesdtos.EstoqueAtualIngredienteDTO;
import com.example.bakery.entities.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM ingrediente;")
    List<Ingrediente> getIngredientes();

    @Query(nativeQuery = true, value = "-- Estoque atual de ingredientes :\n" +
            "-- Altereções da tabela estoque:\n" +
            "-- Aumento da quantidade, diariamente aumenta usando update\n" +
            "-- Diminuição diária por meio das vendas\n" +
            "SELECT i.nome, e.quantidade\n" +
            "FROM estoque e, ingrediente i \n" +
            "WHERE e.id_ingrediente = i.id_ingrediente ;")
    List<EstoqueAtualIngredienteDTO> getEstoqueAtualIngrediente();
}
