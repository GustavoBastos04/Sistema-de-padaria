package com.example.bakery.repositories;

import com.example.bakery.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM PRODUTO;")
    List<Produto> getProdutos();
}
