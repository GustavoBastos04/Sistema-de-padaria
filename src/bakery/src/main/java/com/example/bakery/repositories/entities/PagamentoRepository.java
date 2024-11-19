package com.example.bakery.repositories.entities;

import com.example.bakery.dtos.functionalitiesdtos.MeioPagamentoDTO;
import com.example.bakery.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM pagamento;")
    List<Pagamento> getPagamentos();

    @Query(nativeQuery = true, value = "SELECT p.tipo, count(p.tipo) AS qtd_vendas, Sum(v.valor) AS valor_total\n" +
            "FROM pagamento AS p, venda AS v\n" +
            "WHERE p.id_venda = v.id_venda  \n" +
            "GROUP BY p.tipo\n" +
            "ORDER BY valor_total DESC;")
    List<MeioPagamentoDTO> getRelatorioMeioPagamento();
}
