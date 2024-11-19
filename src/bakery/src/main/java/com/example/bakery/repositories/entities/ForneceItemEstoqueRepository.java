package com.example.bakery.repositories.entities;

import com.example.bakery.entities.ForneceItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ForneceItemEstoqueRepository extends JpaRepository<ForneceItemEstoque,String> {
    @Query(nativeQuery = true, value="select * from fornece_item_estoque;")
    List<ForneceItemEstoque> getForneceItemEstoque();
}
