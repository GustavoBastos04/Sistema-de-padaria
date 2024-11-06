package com.example.bakery.repositories;

import com.example.bakery.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM pagamento;")
    List<Pagamento> getPagamentos();
}
