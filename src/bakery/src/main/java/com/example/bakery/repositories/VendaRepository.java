package com.example.bakery.repositories;

import com.example.bakery.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

import com.example.bakery.dto.VendaLucroDTO;
import com.example.bakery.dto.ProdutoLucroDTO;
import com.example.bakery.dto.PeriodoLucroDTO;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM venda")
    List<Venda> getVendas();

    // Lucro Geral por Venda
    @Query(nativeQuery = true, value = """
        WITH CustoVenda AS (
            SELECT 
                iv.venda_id_venda,
                SUM(fie.preco * pci.quantidade) AS custo_total_ingredientes
            FROM 
                item_venda AS iv
            JOIN 
                produto_constituido_ingrediente AS pci ON iv.produto_id_produto = pci.produto_id_produto
            JOIN 
                ingrediente AS i ON pci.ingrediente_id_ingrediente = i.id_ingrediente
            JOIN 
                fornece_item_estoque AS fie ON i.estoque_id_item = fie.estoque_id_item
            GROUP BY 
                iv.venda_id_venda
        )
        SELECT 
            v.id_venda AS idVenda,
            v.valor AS receita,
            COALESCE(cv.custo_total_ingredientes, 0) AS custo,
            v.valor - COALESCE(cv.custo_total_ingredientes, 0) AS lucro
        FROM 
            venda AS v
        LEFT JOIN 
            CustoVenda AS cv ON v.id_venda = cv.venda_id_venda
    """)
    List<VendaLucroDTO> findLucroGeralPorVenda();

    // Lucro por Produto
    @Query(nativeQuery = true, value = """
        WITH CustoProduto AS (
            SELECT 
                pci.produto_id_produto,
                SUM(fie.preco * pci.quantidade) AS custo_total_ingredientes
            FROM 
                produto_constituido_ingrediente AS pci
            JOIN 
                ingrediente AS i ON pci.ingrediente_id_ingrediente = i.id_ingrediente
            JOIN 
                fornece_item_estoque AS fie ON i.estoque_id_item = fie.estoque_id_item
            GROUP BY 
                pci.produto_id_produto
        ), ReceitaProduto AS (
            SELECT 
                iv.produto_id_produto,
                SUM(v.valor) AS receita_total
            FROM 
                venda AS v
            JOIN 
                item_venda AS iv ON v.id_venda = iv.venda_id_venda
            GROUP BY 
                iv.produto_id_produto
        )
        SELECT 
            p.id_produto AS idProduto,
            p.nome,
            rp.receita_total AS receita,
            COALESCE(cp.custo_total_ingredientes, 0) AS custo,
            rp.receita_total - COALESCE(cp.custo_total_ingredientes, 0) AS lucro
        FROM 
            ReceitaProduto AS rp
        JOIN 
            produto AS p ON rp.produto_id_produto = p.id_produto
        LEFT JOIN 
            CustoProduto AS cp ON rp.produto_id_produto = cp.produto_id_produto
    """)
    List<ProdutoLucroDTO> findLucroPorProduto();

    // Lucro em Determinado Período
    @Query(nativeQuery = true, value = """
        WITH CustoVenda AS (
            SELECT 
                iv.venda_id_venda,
                SUM(fie.preco * pci.quantidade) AS custo_total_ingredientes
            FROM 
                item_venda AS iv
            JOIN 
                produto_constituido_ingrediente AS pci ON iv.produto_id_produto = pci.produto_id_produto
            JOIN 
                ingrediente AS i ON pci.ingrediente_id_ingrediente = i.id_ingrediente
            JOIN 
                fornece_item_estoque AS fie ON i.estoque_id_item = fie.estoque_id_item
            GROUP BY 
                iv.venda_id_venda
        ), Receita_Periodo AS (
            SELECT
                v.id_venda,
                v.valor,
                v.data_de_venda
            FROM
                venda AS v
            WHERE 
                v.data_de_venda BETWEEN :dataInicial AND :dataFinal
        ) 	
        SELECT
            :dataInicial AS dataInicial,
            :dataFinal AS dataFinal,
            rep.id_venda AS idVenda,
            rep.valor AS receita,
            COALESCE(cv.custo_total_ingredientes, 0) AS custo,
            rep.valor - COALESCE(cv.custo_total_ingredientes, 0) AS lucro
        FROM
            Receita_Periodo AS rep
        LEFT JOIN
            CustoVenda AS cv ON rep.id_venda = cv.venda_id_venda
    """)
    List<PeriodoLucroDTO> findLucroPorPeriodo(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);


}

