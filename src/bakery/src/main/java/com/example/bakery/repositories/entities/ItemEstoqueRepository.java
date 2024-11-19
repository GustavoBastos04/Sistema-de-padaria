package com.example.bakery.repositories.entities;

import com.example.bakery.entities.ItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemEstoqueRepository extends JpaRepository<ItemEstoque, Long> {

    @Query(nativeQuery = true, value="SELECT * FROM item_estoque")
    List<ItemEstoque> getItems();
}
