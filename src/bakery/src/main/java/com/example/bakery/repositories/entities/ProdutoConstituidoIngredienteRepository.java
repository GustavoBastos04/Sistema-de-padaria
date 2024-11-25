package com.example.bakery.repositories.entities;

import com.example.bakery.entities.ProdutoConstituidoIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoConstituidoIngredienteRepository extends JpaRepository<ProdutoConstituidoIngrediente, Long> {

    @Query(nativeQuery = true, value = "select * from produto_constituido_ingrediente;")
    List<ProdutoConstituidoIngrediente> getProdutoConstIngred();
}
