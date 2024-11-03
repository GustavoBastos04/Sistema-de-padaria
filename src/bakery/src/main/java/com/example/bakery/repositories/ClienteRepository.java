package com.example.bakery.repositories;

import com.example.bakery.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
// Native Queries that we want to do in SQL DB
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM cliente;")
    List<Cliente> findAllClientData();

    @Query(nativeQuery = true, value =
            "SELECT * FROM cliente where cliente.tipo_de_assinatura = :tipo_de_assinatura")
    List<Cliente> findClientByType(String tipo_de_assinatura);
}
