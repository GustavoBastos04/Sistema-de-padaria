package com.example.bakery.repositories.entities;

import com.example.bakery.dtos.functionalitiesdtos.ConsultaEstoqueIngredienteDTO;
import com.example.bakery.entities.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM ingrediente;")
    List<Ingrediente> getIngredientes();

    @Query(nativeQuery = true, value = "SELECT i.nome, e.quantidade, e.data_validade \n" +
            "FROM estoque AS e, ingrediente AS i\n" +
            "WHERE e.id_ingrediente = i.id_ingrediente\n" +
            "ORDER BY e.data_validade;")
    List<ConsultaEstoqueIngredienteDTO> getEstoqueAtualIngrediente();

    @Query(nativeQuery = true, value = "SELECT i.nome, e.quantidade, e.data_validade \n" +
            "FROM estoque AS e, ingrediente AS i\n" +
            "WHERE e.id_ingrediente = i.id_ingrediente AND data_validade < :param\n" +
            "ORDER BY e.data_validade;")
    List<ConsultaEstoqueIngredienteDTO> getIngredienteVencido(@Param("param") Date param);



    @Query(nativeQuery = true, value= "SELECT i.nome, e.quantidade, e.data_validade \n" +
            "FROM estoque AS e, ingrediente AS i\n" +
            "WHERE e.id_ingrediente = i.id_ingrediente AND \n" +
            "e.data_validade >= :paramDate AND \n" +
            "e.data_validade <= :paramFutureDate \n" +
            "ORDER BY e.data_validade;")
    List<ConsultaEstoqueIngredienteDTO> getCustomIngredienteProximoExpirar(@Param("paramDate") Date paramDate, @Param("paramFutureDate") Date paramFutureDate);
}
