<<<<<<< Updated upstream
SET search_path TO padaria;
=======
SET search_path TO padaria, public;
>>>>>>> Stashed changes

-- Desconto para Cliente Cadastrado
-- Adcionei COALESCENCE para evitar valores nulos
SELECT 
    c.nome,
    c.cpf,
    ROUND(COALESCE(SUM(v.valor),0),2) AS total_gasto,                            -- mostra o total gasto antes do desconto
    CASE 
        WHEN c.tipo_de_assinatura = 'Premium' THEN COALESCE(SUM(v.valor), 0) * 0.10  -- desconto de 10% para clientes Premium
        WHEN c.tipo_de_assinatura = 'Basic' THEN COALESCE(SUM(v.valor), 0) * 0.05    -- desconto de 5% para clientes Basic
        ELSE 0                                                          -- sem desconto para outros tipos
    END AS desconto, 
    ROUND(COALESCE(SUM(v.valor),0),2) - CASE 
        WHEN c.tipo_de_assinatura = 'Premium' THEN COALESCE(SUM(v.valor), 0) * 0.10  -- valor final após desconto de 10% para Premium
        WHEN c.tipo_de_assinatura = 'Basic' THEN COALESCE(SUM(v.valor), 0) * 0.05    -- valor final após desconto de 5% para Basic
        ELSE 0                                                          -- sem desconto para outros tipos
    END AS total_com_desconto
FROM
    cliente AS c
JOIN
    cliente_gera_venda AS cv ON c.cpf = cv.cliente_cpf
JOIN
    venda AS v ON cv.venda_id_venda = v.id_venda
GROUP BY
    c.cpf, c.nome;

-- LUCRO POR VENDA
-- pci: produto_consituido_ingrediente (*id_produto, id_ingrediente*, quantidade)
-- fi: fornece_ingrediente (*fornecedor_cnpj, id_ingrediente*, quantidade, preco)
-- v: venda (*id_venda*, valor, data_de_venda)
-- cp: custo_produto -> subtabela
-- iv: item_venda (*id_produto, id_venda*)
-- p: produto (*id_produto*, nome, valor)
-- COALESCE: lida com valores não nulos
-- WITH: cria subtabelas

WITH custo_produto AS (
    SELECT
        pci.id_produto,
        SUM(pci.quantidade * fi.preco) AS custo_total
    FROM
        produto_constituido_ingrediente pci
    INNER JOIN
        fornece_ingrediente fi ON pci.id_ingrediente = fi.id_ingrediente
    GROUP BY
        pci.id_produto
),
lucro_por_venda AS (
    SELECT
        v.id_venda,
        SUM(p.valor) AS receita_total,
        SUM(COALESCE(cp.custo_total, 0)) AS custo_total,
        SUM(p.valor) - SUM(COALESCE(cp.custo_total, 0)) AS lucro
    FROM
        venda v
    INNER JOIN
        item_venda iv ON v.id_venda = iv.id_venda
    INNER JOIN
        produto p ON iv.id_produto = p.id_produto
    LEFT JOIN
        custo_produto cp ON iv.id_produto = cp.id_produto
    GROUP BY
        v.id_venda
)
SELECT
    id_venda,
    receita_total,
    custo_total,
    lucro
FROM
    lucro_por_venda;


-- Lucro por Produto
WITH CustoProduto AS (
    SELECT 
        pci.id_produto,
        SUM(fi.preco * pci.quantidade) AS custo_total_ingredientes
    FROM 
        produto_constituido_ingrediente AS pci
    JOIN 
        ingrediente AS i ON pci.id_ingrediente = i.id_ingrediente
    JOIN 
        fornece_ingrediente AS fi ON i.id_ingrediente = fi.id_ingrediente
    GROUP BY 
        pci.id_produto
), 
ReceitaProduto AS (
    SELECT 
        iv.id_produto,
        SUM(v.valor) AS receita_total
    FROM 
        venda AS v
    JOIN 
        item_venda AS iv ON v.id_venda = iv.id_venda
    GROUP BY 
        iv.id_produto
)
SELECT 
    p.id_produto,
    p.nome,
    rp.receita_total AS receita,
    COALESCE(cp.custo_total_ingredientes, 0) AS custo,
    rp.receita_total - COALESCE(cp.custo_total_ingredientes, 0) AS lucro
FROM 
    ReceitaProduto AS rp
JOIN 
    produto AS p ON rp.id_produto = p.id_produto
LEFT JOIN 
    CustoProduto AS cp ON rp.id_produto = cp.id_produto;



-- Lucro em determinado período (no sistema as datas são customizáveis
WITH CustoVenda AS (
    SELECT 
        iv.id_venda,
        SUM(pci.quantidade * fi.preco) AS custo_total_ingredientes
    FROM 
        item_venda iv
    INNER JOIN 
        produto_constituido_ingrediente pci ON iv.id_produto = pci.id_produto
    INNER JOIN 
        fornece_ingrediente fi ON pci.id_ingrediente = fi.id_ingrediente
    GROUP BY 
        iv.id_venda
), Receita_Periodo AS (
    SELECT
        v.id_venda,
        v.valor,
        v.data_de_venda
    FROM
        venda v
    WHERE 
        v.data_de_venda BETWEEN '2024-01-01' AND '2024-12-01'
) 	
SELECT
    '2024-01-01' AS Data_Inicial,  -- Exibe a data inicial
    '2024-12-01' AS Data_Final,    -- Exibe a data final
    ROUND(SUM(rep.valor), 2) AS receita_total,
    ROUND(SUM(COALESCE(cv.custo_total_ingredientes, 0)), 2) AS custo_total,
    ROUND(SUM(rep.valor) - SUM(COALESCE(cv.custo_total_ingredientes, 0)), 2) AS lucro_total
FROM
    Receita_Periodo rep
LEFT JOIN
    CustoVenda cv ON rep.id_venda = cv.id_venda;
	
-- Relatorio de meios de pagamento
-- Quantidade de vendas por tipo de pagamento e valor total das vendas
SELECT p.tipo, count(p.tipo) AS qtd_vendas, Sum(v.valor) AS valor_total
FROM Padaria.pagamento AS p, Padaria.venda AS v
WHERE p.venda_id_venda = v.id_venda  
GROUP BY p.tipo
ORDER BY valor_total DESC;
















