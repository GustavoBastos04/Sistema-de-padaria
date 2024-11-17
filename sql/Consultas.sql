SET search_path TO Padaria;

-- Desconto para Cliente Cadastrado
-- Adcionei COALESCENCE para evitar valores nulos
SELECT 
    c.nome,
    c.cpf,
    COALESCE(SUM(v.valor),0) AS total_gasto,                            -- mostra o total gasto antes do desconto
    CASE 
        WHEN c.tipo_de_assinatura = 'Premium' THEN COALESCE(SUM(v.valor), 0) * 0.10  -- desconto de 10% para clientes Premium
        WHEN c.tipo_de_assinatura = 'Basic' THEN COALESCE(SUM(v.valor), 0) * 0.05    -- desconto de 5% para clientes Basic
        ELSE 0                                                          -- sem desconto para outros tipos
    END AS desconto, 
    COALESCE(SUM(v.valor),0) - CASE 
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
        iv.venda_id_venda,
        SUM(fie.preco * pci.quantidade) as custo_total_ingredientes
    FROM 
        item_venda as iv
    JOIN 
        produto_constituido_ingrediente as pci on iv.produto_id_produto = pci.produto_id_produto
    JOIN 
        ingrediente as i on pci.ingrediente_id_ingrediente = i.id_ingrediente
    JOIN 
        fornece_item_estoque as fie on i.estoque_id_item = fie.estoque_id_item
    GROUP BY 
        iv.venda_id_venda
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
    CustoVenda as cv on v.id_venda = cv.venda_id_venda;


-- Lucro por Produto
WITH CustoProduto as (
    SELECT 
        pci.produto_id_produto,
        SUM(fie.preco * pci.quantidade) as custo_total_ingredientes
    FROM 
        produto_constituido_ingrediente as pci
    JOIN 
        ingrediente as i on pci.ingrediente_id_ingrediente = i.id_ingrediente
    JOIN 
        fornece_item_estoque as fie on i.estoque_id_item = fie.estoque_id_item
    GROUP BY 
        pci.produto_id_produto
), ReceitaProduto as (
    SELECT 
        iv.produto_id_produto,
        SUM(v.valor) as receita_total
    FROM 
        venda as v
    JOIN 
        item_venda as iv on v.id_venda = iv.venda_id_venda
    GROUP BY 
        iv.produto_id_produto
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
    Padaria.produto as p on rp.produto_id_produto = p.id_produto
LEFT JOIN 
    CustoProduto as cp on rp.produto_id_produto = cp.produto_id_produto;


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
            Padaria.produto_constituido_ingrediente as pci on iv.produto_id_produto = pci.produto_id_produto
        JOIN 
            Padaria.ingrediente as i on pci.ingrediente_id_ingrediente = i.id_ingrediente
        JOIN 
            Padaria.fornece_item_estoque as fie on i.estoque_id_item = fie.estoque_id_item
        GROUP BY 
            iv.venda_id_venda
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
        CustoVenda as cv on rep.id_venda = cv.venda_id_venda';
END $$;

-- Relatorio de meios de pagamento
-- Quantidade de vendas por tipo de pagamento e valor total das vendas
SELECT p.tipo, count(p.tipo) AS qtd_vendas, Sum(v.valor) AS valor_total
FROM Padaria.pagamento AS p, Padaria.venda AS v
WHERE p.venda_id_venda = v.id_venda  
GROUP BY p.tipo
ORDER BY valor_total DESC;
















