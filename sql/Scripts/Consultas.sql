SET search_path TO Padaria, public;


-- Desconto para Cliente Cadastrado
SELECT 
	c.nome,
	c.cpf,
-- desconto de 10%
	SUM(v.valor) as total_gasto,		-- mostra o total gasto antes do desconto
	SUM(v.valor) * 0.10 as desconto,	-- mostra qual será o desconto
	SUM(v.valor) - SUM(v.valor)* 0.10 as total_com_desconto	-- valor final após o desconto
FROM
	cliente as c
JOIN
-- chamado apenas para ligar cliente com venda
	cliente_gera_venda as cv on c.cpf = cv.cliente_cpf
JOIN
	venda as v on cv.venda_id_venda = v.id_venda
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
















