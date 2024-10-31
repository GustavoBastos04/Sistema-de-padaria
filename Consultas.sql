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

