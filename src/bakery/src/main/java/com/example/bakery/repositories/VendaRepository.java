package com.example.bakery.repositories;

import com.example.bakery.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM venda")
    List<Venda> getVendas();

}
