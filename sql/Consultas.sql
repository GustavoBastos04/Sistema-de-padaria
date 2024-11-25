SET search_path TO Padaria, public;

-- Desconto para Cliente Cadastrado
SELECT 
    c.nome,
    c.cpf,
    SUM(v.valor) AS total_gasto,                            -- mostra o total gasto antes do desconto
    CASE 
        WHEN c.tipo_de_assinatura = 'Premium' THEN SUM(v.valor) * 0.10  -- desconto de 10% para clientes Premium
        WHEN c.tipo_de_assinatura = 'Basic' THEN SUM(v.valor) * 0.05    -- desconto de 5% para clientes Basic
        ELSE 0                                                          -- sem desconto para outros tipos
    END AS desconto, 
    SUM(v.valor) - CASE 
        WHEN c.tipo_de_assinatura = 'Premium' THEN SUM(v.valor) * 0.10  -- valor final após desconto de 10% para Premium
        WHEN c.tipo_de_assinatura = 'Basic' THEN SUM(v.valor) * 0.05    -- valor final após desconto de 5% para Basic
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


-- Lucro Geral por Venda
-- Lucro por produto
-- Lucro em determinado periodo 
-- WITH é utilizado para criar uma "subtabela"

-- Significado das siglas:
-- fie = fornece_item_estoque
-- pci = produto_constituido_ingrediente
-- i = ingredientes
-- iv = item_venda
-- v = venda


-- Lucro Geral por Venda
WITH CustoVenda as (
    SELECT 
        iv.id_venda,
        SUM(fie.preco * pci.quantidade) as custo_total_ingredientes
    FROM 
        item_venda as iv
    JOIN 
        produto_constituido_ingrediente as pci on iv.id_produto = pci.id_produto
    JOIN 
        ingrediente as i on pci.id_ingrediente = i.id_ingrediente
    JOIN 
        fornece_ingrediente as fie on i.id_ingrediente = fie.id_ingrediente
    GROUP BY 
        iv.id_venda
)
SELECT 
    v.id_venda,
    v.valor as Valor_que_Cliente_Gastou,
    COALESCE(cv.custo_total_ingredientes, 0) as Custo_para_Produzir_Cliente_Consumiu,
    v.valor - COALESCE(cv.custo_total_ingredientes, 0) as Lucro
FROM 
    venda as v
LEFT JOIN 
    CustoVenda as cv on v.id_venda = cv.id_venda;

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
        fornece_ingrediente AS fi ON fi.id_ingrediente = i.id_ingrediente
    GROUP BY 
        pci.id_produto
), ReceitaProduto AS (
    SELECT 
        iv.id_produto,
        SUM(p.valor) AS receita_total
    FROM 
        item_venda AS iv
    JOIN 
        produto AS p ON iv.id_produto = p.id_produto
    JOIN 
        venda AS v ON iv.id_venda = v.id_venda
    GROUP BY 
        iv.id_produto
)
SELECT 
    p.id_produto,
    p.nome,
    COALESCE(rp.receita_total, 0) AS Valor_Vendido,
    COALESCE(cp.custo_total_ingredientes, 0) AS Valor_Gasto_para_Produzir,
    COALESCE(rp.receita_total, 0) - COALESCE(cp.custo_total_ingredientes, 0) AS lucro
FROM 
    produto AS p
LEFT JOIN 
    ReceitaProduto AS rp ON p.id_produto = rp.id_produto
LEFT JOIN 
    CustoProduto AS cp ON p.id_produto = cp.id_produto;

--v.data_de_venda BETWEEN '2024-12-01' AND '2024-12-12'
--Tem que colocar a data aqui, pensei em deixar uma variavel no lugar
-- Lucro em determinado periodo
WITH CustoVenda AS (
    SELECT 
        iv.id_venda,
        SUM(fie.preco * pci.quantidade) AS custo_total_ingredientes
    FROM 
        item_venda AS iv
    JOIN 
        produto_constituido_ingrediente AS pci ON iv.id_produto = pci.id_produto
    JOIN 
        ingrediente AS i ON pci.id_ingrediente = i.id_ingrediente
    JOIN 
        fornece_ingrediente AS fie ON i.id_ingrediente = fie.id_ingrediente
    GROUP BY 
        iv.id_venda
), Receita_Periodo AS (
    SELECT
        v.id_venda,
        v.valor,
        v.data_de_venda
    FROM
        venda AS v
    WHERE 
        v.data_de_venda BETWEEN '2024-01-01' AND '2024-12-01'
) 	
SELECT
    '2024-01-01' AS Data_Inicial,   -- Exibe a data inicial
    '2024-12-01' AS Data_Final,     -- Exibe a data final
    SUM(rep.valor) AS total_entrada,  -- Soma das receitas
    SUM(COALESCE(cv.custo_total_ingredientes, 0)) AS total_saida,  -- Soma dos custos
    SUM(rep.valor) - SUM(COALESCE(cv.custo_total_ingredientes, 0)) AS lucro  -- Subtração entre receita e custo
FROM
    Receita_Periodo AS rep
LEFT JOIN
    CustoVenda AS cv ON rep.id_venda = cv.id_venda
GROUP BY
    Data_Inicial, Data_Final;



-- Relatorio de meios de pagamento
-- Quantidade de vendas por tipo de pagamento e valor total das vendas
SELECT p.tipo, count(p.tipo) AS qtd_vendas, Sum(v.valor) AS valor_total
FROM Padaria.pagamento AS p, Padaria.venda AS v
WHERE p.id_venda = v.id_venda  
GROUP BY p.tipo
ORDER BY valor_total DESC;


-- Estoque
SELECT i.nome, e.quantidade, e.data_validade 
FROM Padaria.estoque AS e, Padaria.ingrediente AS i
WHERE e.id_ingrediente = i.id_ingrediente
ORDER BY e.data_validade;

-- Ingredientes do estoque que já expiraram
SELECT i.nome, e.quantidade, e.data_validade 
FROM Padaria.estoque AS e, Padaria.ingrediente AS i
WHERE e.id_ingrediente = i.id_ingrediente AND data_validade < CURRENT_DATE
ORDER BY e.data_validade;

-- Ingredientes do estoque que estão próximos de expirarem (entre hoje e dois meses)
SELECT i.nome, e.quantidade, e.data_validade 
FROM Padaria.estoque AS e, Padaria.ingrediente AS i
WHERE e.id_ingrediente = i.id_ingrediente AND 
e.data_validade >= CURRENT_DATE AND 
e.data_validade <= CURRENT_DATE + INTERVAL '2 month'
ORDER BY e.data_validade;

-- Produtos que restaram do dia anterior
SELECT p.nome, pr.quantidade
FROM padaria.produtos_restantes pr, padaria.produto p 
WHERE pr.id_produto = p.id_produto;
