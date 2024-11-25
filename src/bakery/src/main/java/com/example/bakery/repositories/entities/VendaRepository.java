package com.example.bakery.repositories.entities;

import com.example.bakery.dtos.functionalitiesdtos.LucroDeterminadoPeriodoDTO;
import com.example.bakery.dtos.functionalitiesdtos.LucroGeralVendaDTO;
import com.example.bakery.dtos.functionalitiesdtos.LucroProdutoDTO;
import com.example.bakery.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
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

    @Query(nativeQuery = true, value = "" +
            "-- Lucro por Produto\n" +
            "WITH CustoProduto AS (\n" +
            "    SELECT \n" +
            "        pci.id_produto,\n" +
            "        SUM(fi.preco * pci.quantidade) AS custo_total_ingredientes\n" +
            "    FROM \n" +
            "        produto_constituido_ingrediente AS pci\n" +
            "    JOIN \n" +
            "        ingrediente AS i ON pci.id_ingrediente = i.id_ingrediente\n" +
            "    JOIN \n" +
            "        fornece_ingrediente AS fi ON i.id_ingrediente = fi.id_ingrediente\n" +
            "    GROUP BY \n" +
            "        pci.id_produto\n" +
            "), \n" +
            "ReceitaProduto AS (\n" +
            "    SELECT \n" +
            "        iv.id_produto,\n" +
            "        SUM(v.valor) AS receita_total\n" +
            "    FROM \n" +
            "        venda AS v\n" +
            "    JOIN \n" +
            "        item_venda AS iv ON v.id_venda = iv.id_venda\n" +
            "    GROUP BY \n" +
            "        iv.id_produto\n" +
            ")\n" +
            "SELECT \n" +
            "    p.id_produto,\n" +
            "    p.nome,\n" +
            "    rp.receita_total AS receita,\n" +
            "    COALESCE(cp.custo_total_ingredientes, 0) AS custo,\n" +
            "    rp.receita_total - COALESCE(cp.custo_total_ingredientes, 0) AS lucro\n" +
            "FROM \n" +
            "    ReceitaProduto AS rp\n" +
            "JOIN \n" +
            "    produto AS p ON rp.id_produto = p.id_produto\n" +
            "LEFT JOIN \n" +
            "    CustoProduto AS cp ON rp.id_produto = cp.id_produto;\n" +
            "\n")
    List<LucroProdutoDTO> getLucroPorProduto();

    @Query(nativeQuery = true, value ="" +
            "WITH CustoVenda AS (\n" +
            "    SELECT \n" +
            "        iv.id_venda,\n" +
            "        SUM(pci.quantidade * fi.preco) AS custo_total_ingredientes\n" +
            "    FROM \n" +
            "        item_venda iv\n" +
            "    INNER JOIN \n" +
            "        produto_constituido_ingrediente pci ON iv.id_produto = pci.id_produto\n" +
            "    INNER JOIN \n" +
            "        fornece_ingrediente fi ON pci.id_ingrediente = fi.id_ingrediente\n" +
            "    GROUP BY \n" +
            "        iv.id_venda\n" +
            "), Receita_Periodo AS (\n" +
            "    SELECT\n" +
            "        v.id_venda,\n" +
            "        v.valor,\n" +
            "        v.data_de_venda\n" +
            "    FROM\n" +
            "        venda v\n" +
            "    WHERE \n" +
            "        v.data_de_venda BETWEEN :begginingDate AND :endDate\n" +
            ") \t\n" +
            "SELECT\n" +
            "    :begginingDate AS Data_Inicial,  -- Exibe a data inicial\n" +
            "    :endDate AS Data_Final,    -- Exibe a data final\n" +
            "    ROUND(SUM(rep.valor), 2) AS receita_total,\n" +
            "    ROUND(SUM(COALESCE(cv.custo_total_ingredientes, 0)), 2) AS custo_total,\n" +
            "    ROUND(SUM(rep.valor) - SUM(COALESCE(cv.custo_total_ingredientes, 0)), 2) AS lucro_total\n" +
            "FROM\n" +
            "    Receita_Periodo rep\n" +
            "LEFT JOIN\n" +
            "    CustoVenda cv ON rep.id_venda = cv.id_venda;\n")
    List<LucroDeterminadoPeriodoDTO> getLucroDeterminadoPeriodo(@Param("begginingDate") Date begginingDate, @Param("endDate") Date endDate);

    @Query(nativeQuery = true, value= "" +
            "-- Lucro por Produto \n" +
            "            WITH CustoProduto AS ( \n" +
            "                SELECT  \n" +
            "                    pci.id_produto, \n" +
            "                    SUM(fi.preco * pci.quantidade) AS custo_total_ingredientes \n" +
            "                FROM  \n" +
            "                    produto_constituido_ingrediente AS pci \n" +
            "                JOIN  \n" +
            "                    ingrediente AS i ON pci.id_ingrediente = i.id_ingrediente \n" +
            "                JOIN  \n" +
            "                    fornece_ingrediente AS fi ON i.id_ingrediente = fi.id_ingrediente \n" +
            "                GROUP BY  \n" +
            "                    pci.id_produto \n" +
            "            ),  \n" +
            "            ReceitaProduto AS ( \n" +
            "                SELECT  \n" +
            "                    iv.id_produto, \n" +
            "                    SUM(v.valor) AS receita_total \n" +
            "                FROM  \n" +
            "                    venda AS v \n" +
            "                JOIN  \n" +
            "                    item_venda AS iv ON v.id_venda = iv.id_venda \n" +
            "                GROUP BY  \n" +
            "                    iv.id_produto \n" +
            "            ) \n" +
            "            SELECT  \n" +
            "                p.id_produto,\n" +
            "                p.nome, \n" +
            "                rp.receita_total AS receita, \n" +
            "                COALESCE(cp.custo_total_ingredientes, 0) AS custo, \n" +
            "                rp.receita_total - COALESCE(cp.custo_total_ingredientes, 0) AS lucro \n" +
            "            FROM  \n" +
            "                ReceitaProduto AS rp \n" +
            "            JOIN  \n" +
            "                produto AS p ON rp.id_produto = p.id_produto \n" +
            "            LEFT JOIN  \n" +
            "                CustoProduto AS cp ON rp.id_produto = cp.id_produto\n" +
            "\t\t\t\tWHERE p.id_produto = :produto; \n" +
            "            ")
    List<LucroProdutoDTO> getLucroSelecionadoDTO(@Param("produto") Long produtoId);
}


