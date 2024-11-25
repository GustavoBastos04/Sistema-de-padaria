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
	-- receita é o total pago na venda
    v.valor as receita,
    COALESCE(cv.custo_total_ingredientes, 0) as custo,
    v.valor - COALESCE(cv.custo_total_ingredientes, 0) as lucro
FROM 
    venda as v
LEFT JOIN 
    CustoVenda as cv on v.id_venda = cv.id_venda;


-- Lucro por Produto
WITH CustoProduto as (
    SELECT 
        pci.id_produto,
        SUM(fie.preco * pci.quantidade) as custo_total_ingredientes
    FROM 
        produto_constituido_ingrediente as pci
    JOIN 
        ingrediente as i on pci.id_ingrediente = i.id_ingrediente
    JOIN 
        fornece_item_estoque as fie on i.estoque_id_item = fie.estoque_id_item
    GROUP BY 
        pci.id_produto
), ReceitaProduto as (
    SELECT 
        iv.id_produto,
        SUM(v.valor) as receita_total
    FROM 
        venda as v
    JOIN 
        item_venda as iv on v.id_venda = iv.id_venda
    GROUP BY 
        iv.id_produto
)
SELECT 
    p.id_produto,
    p.nome,
    rp.receita_total as receita,
    COALESCE(cp.custo_total_ingredientes, 0) as custo,
    rp.receita_total - COALESCE(cp.custo_total_ingredientes, 0) as lucro
FROM 
    ReceitaProduto as rp
JOIN 
    Padaria.produto as p on rp.id_produto = p.id_produto
LEFT JOIN 
    CustoProduto as cp on rp.id_produto = cp.id_produto;


--v.data_de_venda BETWEEN '2024-12-01' AND '2024-12-12'
--Tem que colocar a data aqui, pensei em deixar uma variavel no lugar
-- Lucro em determinado periodo
DO $$ 
DECLARE
    data_inicial DATE := '2024-01-01';
    data_final DATE := '2024-12-01';
BEGIN
    EXECUTE '
	WITH CustoVenda as (
        SELECT 
            iv.venda_id_venda,
            SUM(fie.preco * pci.quantidade) as custo_total_ingredientes
        FROM 
            Padaria.item_venda as iv
        JOIN 
            Padaria.produto_constituido_ingrediente as pci on iv.id_produto = pci.id_produto
        JOIN 
            Padaria.ingrediente as i on pci.id_ingrediente = i.id_ingrediente
        JOIN 
            Padaria.fornece_item_estoque as fie on i.estoque_id_item = fie.estoque_id_item
        GROUP BY 
            iv.id_venda
    ), Receita_Periodo as (
        SELECT
            v.id_venda,
            v.valor,
            v.data_de_venda
        FROM
            Padaria.venda as v
        WHERE 
            v.data_de_venda BETWEEN' || quote_literal(data_inicial) || 'AND' || quote_literal(data_final) ||'
    ) 	
    SELECT
		-- Exibir o período selecionado
		''' || data_inicial || ''' AS Data_Inicial,  -- Exibe a data inicial
        ''' || data_final || ''' AS Data_Final,    -- Exibe a data final
        rep.id_venda,
        rep.valor as receita,
        COALESCE(cv.custo_total_ingredientes, 0) as custo,
        rep.valor - COALESCE(cv.custo_total_ingredientes, 0) as lucro
    FROM
        Receita_Periodo as rep
    LEFT JOIN
        CustoVenda as cv on rep.id_venda = cv.id_venda';
END $$;


/*
WITH CustoVenda AS (
    SELECT 
        iv.venda_id_venda,
        SUM(fie.preco * pci.quantidade) AS custo_total_ingredientes
    FROM 
        Padaria.item_venda AS iv
    JOIN 
        Padaria.produto_constituido_ingrediente AS pci ON iv.id_produto = pci.id_produto
    JOIN 
        Padaria.ingrediente AS i ON pci.id_ingrediente = i.id_ingrediente
    JOIN 
        Padaria.fornece_item_estoque AS fie ON i.estoque_id_item = fie.estoque_id_item
    GROUP BY 
        iv.venda_id_venda
), Receita_Periodo AS (
    SELECT
        v.id_venda,
        v.valor,
        v.data_de_venda
    FROM
        Padaria.venda AS v
    WHERE 
        v.data_de_venda BETWEEN '2024-01-01' AND '2024-12-01'
) 	
SELECT
    '2024-01-01' AS Data_Inicial,   -- Exibe a data inicial
    '2024-12-01' AS Data_Final,     -- Exibe a data final
    rep.id_venda,
    rep.valor AS receita,
    COALESCE(cv.custo_total_ingredientes, 0) AS custo,
    rep.valor - COALESCE(cv.custo_total_ingredientes, 0) AS lucro
FROM
    Receita_Periodo AS rep
LEFT JOIN
    CustoVenda AS cv ON rep.id_venda = cv.venda_id_venda;
*/


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












