package com.example.bakery.repositories.entities;

import com.example.bakery.dtos.functionalitiesdtos.ProdutosRestantesDTO;
import com.example.bakery.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM PRODUTO;")
    List<Produto> getProdutos();

    @Query(nativeQuery = true, value = "-- Produtos que restaram do dia anterior\n" +
            "SELECT p.nome, pr.quantidade\n" +
            "FROM produtos_restantes pr, produto p \n" +
            "WHERE pr.id_produto = p.id_produto;\n")
    List<ProdutosRestantesDTO> getProdutosRestantes();

}
