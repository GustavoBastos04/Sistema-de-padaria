package com.example.bakery.repositories.entities;

import com.example.bakery.dtos.functionalitiesdtos.LucroGeralVendaDTO;
import com.example.bakery.dtos.functionalitiesdtos.LucroProdutoDTO;
import com.example.bakery.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM venda;")
    List<Venda> getVendas();
    /*
    @Query(nativeQuery = true, value="")
    List<LucroGeralVendaDTO> getLucroGeralVenda();

    @Query(nativeQuery = true, value = "")
    List<LucroProdutoDTO> getLucroProduto();
    */
}


