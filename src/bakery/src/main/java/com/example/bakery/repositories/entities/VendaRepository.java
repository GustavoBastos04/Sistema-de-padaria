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

    @Query(nativeQuery = true, value="" +
            "-- pci: produto_consituido_ingrediente (*id_produto, id_ingrediente*, quantidade)\n" +
            "-- fi: fornece_ingrediente (*fornecedor_cnpj, id_ingrediente*, quantidade, preco)\n" +
            "-- v: venda (*id_venda*, valor, data_de_venda)\n" +
            "-- cp: custo_produto -> subtabela\n" +
            "-- iv: item_venda (*id_produto, id_venda*)\n" +
            "-- p: produto (*id_produto*, nome, valor)\n" +
            "-- COALESCE: lida com valores não nulos\n" +
            "-- WITH: cria subtabelas\n" +
            "\n" +
            "\n" +
            "WITH custo_produto AS (\n" +
            "    SELECT\n" +
            "        pci.id_produto,\n" +
            "        SUM(pci.quantidade * fi.preco) AS custo_total\n" +
            "    FROM\n" +
            "        produto_constituido_ingrediente pci\n" +
            "    INNER JOIN\n" +
            "        fornece_ingrediente fi ON pci.id_ingrediente = fi.id_ingrediente\n" +
            "    GROUP BY\n" +
            "        pci.id_produto\n" +
            "),\n" +
            "lucro_por_venda AS (\n" +
            "    SELECT\n" +
            "        v.id_venda,\n" +
            "        SUM(v.valor) AS receita_total,\n" +
            "        SUM(COALESCE(cp.custo_total, 0)) AS custo_total,\n" +
            "        SUM(v.valor) - SUM(COALESCE(cp.custo_total, 0)) AS lucro\n" +
            "    FROM\n" +
            "        venda v\n" +
            "    INNER JOIN\n" +
            "        item_venda iv ON v.id_venda = iv.id_venda\n" +
            "    INNER JOIN\n" +
            "        produto p ON iv.id_produto = p.id_produto\n" +
            "    LEFT JOIN\n" +
            "        custo_produto cp ON iv.id_produto = cp.id_produto\n" +
            "    GROUP BY\n" +
            "        v.id_venda\n" +
            ")\n" +
            "SELECT\n" +
            "    id_venda,\n" +
            "    receita_total,\n" +
            "    custo_total,\n" +
            "    lucro\n" +
            "FROM\n" +
            "    lucro_por_venda;\n")
    List<LucroGeralVendaDTO> getLucroGeralVenda();
    /*
    @Query(nativeQuery = true, value = "")
    List<LucroProdutoDTO> getLucroProduto();
    */
}


