package com.example.bakery.repositories;

import com.example.bakery.entities.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM ingrediente;")
    List<Ingrediente> getIngredientes();
}
