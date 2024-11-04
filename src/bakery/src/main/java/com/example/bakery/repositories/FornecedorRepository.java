package com.example.bakery.repositories;

import com.example.bakery.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM fornecedor;")
    List<Fornecedor> getFornecedores();
}
