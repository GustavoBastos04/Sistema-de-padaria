package com.example.bakery.repositories;

import com.example.bakery.entities.Cliente;
import com.example.bakery.projections.GeneralProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
// Native Queries that we want to do in SQL DB
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(nativeQuery = true, value = "SELECT * from cliente;")
    List<GeneralProjection> findAllClientData();
}
