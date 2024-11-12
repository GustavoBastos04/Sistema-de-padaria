SET search_path TO Padaria, public;

-- Inserções de Vendas para a Tabela Padaria.venda
INSERT INTO Padaria.venda (id_venda, valor) VALUES 
(1,35.50),
(2,22.75),
(3,47.30),
(4,18.90),
(5,62.40),
(6,15.60),
(7,53.20),
(8,29.85),
(9,41.75),
(10,33.60),
(11,57.90),
(12,26.40),
(13,49.50),
(14,19.75),
(15,38.60),
(16,45.30),
(17,21.85),
(18,55.20),
(19,32.40),
(20,67.50);

-- Inserções de Fornecedores para a Tabela Padaria.fornecedor
INSERT INTO Padaria.fornecedor VALUES 
('12.345.678/0001-90', 'Farinha & Cia Ltda', '(11) 3456-7890', 'contato@farinhaecia.com.br', 'Rua das Indústrias', '250', '04500-123', 'São Paulo', 'SP'),
('23.456.789/0001-81', 'Padaria Ingredientes Atacado', '(21) 2345-6789', 'vendas@padariainsumos.com.br', 'Avenida Brasil', '750', '21050-200', 'Rio de Janeiro', 'RJ'),
('34.567.890/0001-72', 'Doces e Massas Distribuidora', '(31) 3456-7890', 'comercial@docesmassas.com.br', 'Rua Minas Gerais', '480', '30190-120', 'Belo Horizonte', 'MG'),
('45.678.901/0001-63', 'Açúcar e Mel Comércio', '(41) 4567-8901', 'contato@acucaremel.com.br', 'Alameda das Mercadorias', '120', '80010-200', 'Curitiba', 'PR'),
('56.789.012/0001-54', 'Trigo Dourado Importadora', '(51) 5678-9012', 'exportacao@trigoourado.com.br', 'Rua dos Importadores', '350', '90010-100', 'Porto Alegre', 'RS'),
('67.890.123/0001-45', 'Confeitaria Primavera Atacado', '(61) 6789-0123', 'vendedor@confeitariaprimavera.com.br', 'Setor de Distribuição', '680', '70070-120', 'Brasília', 'DF'),
('78.901.234/0001-36', 'Chocolate e Cia Ltda', '(71) 7890-1234', 'comercial@chocolateecia.com.br', 'Avenida da Produção', '220', '40010-110', 'Salvador', 'BA'),
('89.012.345/0001-27', 'Ovos e Laticínios Sul', '(81) 8901-2345', 'contato@ovoslaticiniossul.com.br', 'Rua das Fazendas', '550', '51020-300', 'Recife', 'PE'),
('90.123.456/0001-18', 'Panificadora Insumos Norte', '(91) 9012-3456', 'vendas@panificadorainsumos.com.br', 'Travessa Industrial', '180', '66010-140', 'Belém', 'PA'),
('01.234.567/0001-09', 'Fermento e Cia Importações', '(48) 0123-4567', 'importacao@fermentoecia.com.br', 'Rua dos Importadores', '620', '88010-100', 'Florianópolis', 'SC'),
('12.345.678/0002-81', 'Grãos do Centro Distribuidora', '(62) 1234-5678', 'comercial@graoscentro.com.br', 'Avenida Industrial', '310', '74010-010', 'Goiânia', 'GO'),
('23.456.789/0002-72', 'Padaria Express Fornecimentos', '(85) 2345-6789', 'contato@padariaexpress.com.br', 'Rua de Logística', '450', '60010-100', 'Fortaleza', 'CE'),
('34.567.890/0002-63', 'Sabores e Massas Ltda', '(98) 3456-7890', 'vendedor@saboresemassas.com.br', 'Avenida dos Comerciantes', '280', '65010-100', 'São Luís', 'MA'),
('45.678.901/0002-54', 'Ingredientes Gourmet Atacado', '(27) 4567-8901', 'comercial@ingredientesgourmet.com.br', 'Rua das Empresas', '160', '29010-100', 'Vitória', 'ES'),
('56.789.012/0002-45', 'Açúcar Refinado Nacional', '(92) 5678-9012', 'contato@acucarrefinado.com.br', 'Avenida da Produção', '520', '69010-100', 'Manaus', 'AM'),
('67.890.123/0002-36', 'Farelos e Massas Nordeste', '(83) 6789-0123', 'vendas@farelosemassas.com.br', 'Rua Industrial', '390', '58010-100', 'João Pessoa', 'PB'),
('78.901.234/0002-27', 'Grãos do Acre Distribuidora', '(68) 7890-1234', 'comercial@graosacre.com.br', 'Avenida dos Comerciantes', '250', '69900-100', 'Rio Branco', 'AC'),
('89.012.345/0002-18', 'Especiarias Roraima Ltda', '(95) 8901-2345', 'contato@especiariasroraima.com.br', 'Rua de Distribuição', '420', '69300-100', 'Boa Vista', 'RR'),
('90.123.456/0002-09', 'Ingredientes Premium Norte', '(86) 9012-3456', 'vendedor@ingredientespremium.com.br', 'Avenida Logística', '180', '64010-100', 'Teresina', 'PI'),
('01.234.567/0002-00', 'Padaria Plus Fornecimentos', '(84) 0123-4567', 'comercial@padariaplus.com.br', 'Rua Industrial', '560', '59010-100', 'Natal', 'RN');

-- Inserções de Itens de Estoque para a Tabela Padaria.item_estoque
INSERT INTO Padaria.item_estoque VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25),
(26),
(27),
(28),
(29),
(30),
(31),
(32),
(33),
(34),
(35),
(36),
(37),
(38),
(39),
(40);

-- Inserções de Produtos para a Tabela Padaria.produto
INSERT INTO Padaria.produto  VALUES 
(1,'Pão Francês', 0.75, 100, 1),
(2,'Pão de Leite', 8.50, 30, 2),
(3,'Croissant', 5.90, 25, 3),
(4,'Bolo de Chocolate', 45.90, 8, 4),
(5,'Pão de Queijo', 2.50, 50, 5),
(6,'Baguete', 6.90, 20, 6),
(7,'Sonho', 4.50, 35, 7),
(8,'Rosca Doce', 12.90, 15, 8),
(9,'Torta de Frango', 52.90, 5, 9),
(10,'Cookie', 3.50, 40, 10),
(11,'Broa de Milho', 4.90, 25, 11),
(12,'Coxinha', 5.50, 45, 12),
(13,'Empada', 6.50, 30, 13),
(14,'Bolo de Cenoura', 42.90, 7, 14),
(15,'Pão Integral', 9.90, 25, 15),
(16,'Esfiha', 4.90, 40, 16),
(17,'Quiche de Legumes', 48.90, 6, 17),
(18,'Pão de Forma', 11.90, 20, 18),
(19,'Brigadeiro', 2.90, 60, 19),
(20,'Pastel de Nata', 5.90, 35, 20);

-- Inserções de Ingredientes para a Tabela Padaria.ingrediente
INSERT INTO Padaria.ingrediente VALUES 
(1,21, 'Farinha de Trigo'),
(2,22, 'Fermento'),  
(3,23, 'Sal'),  
(4,24, 'Açúcar'),  
(5,25, 'Leite'),
(6,26, 'Ovos'),  
(7,27, 'Manteiga'),  
(8,28, 'Chocolate em Pó'),  
(9,29, 'Polvilho'), 
(10,30, 'Queijo'), 
(11,31, 'Farinha de Milho'),
(12,32, 'Creme de Leite'),
(13,33, 'Leite Condensado'),
(14,34, 'Frutas Secas'),
(15,35, 'Farinha Integral'),
(16,36, 'Gordura Vegetal'),
(17,37, 'Amido de Milho'),
(18,38, 'Essência de Baunilha'),
(19,39, 'Cacau em Pó'), 
(20,40, 'Canela em Pó'); 

-- Inserções de Clientes para a Tabela Padaria.cliente
INSERT INTO Padaria.cliente VALUES 
('123.456.789-01', 'Maria Silva Santos', 'Premium', '(11) 98765-4321', 'maria.santos@email.com', 'Rua das Flores', '150', '04500-123', 'São Paulo', 'SP'),
('987.654.321-09', 'João Pedro Oliveira', 'Basic', '(21) 97654-3210', 'joao.oliveira@email.com', 'Avenida Central', '85', '22640-100', 'Rio de Janeiro', 'RJ'),
('456.789.123-45', 'Ana Beatriz Rocha', 'Premium', '(31) 96543-2109', 'ana.rocha@email.com', 'Travessa do Comércio', '42', '30190-120', 'Belo Horizonte', 'MG'),
('321.654.987-65', 'Carlos Eduardo Souza', 'Premium', '(41) 95432-1098', 'carlos.souza@email.com', 'Rua Principal', '273', '80010-200', 'Curitiba', 'PR'),
('654.321.987-54', 'Juliana Martins Costa', 'Basic', '(51) 94321-0987', 'juliana.costa@email.com', 'Alameda dos Anjos', '67', '90010-100', 'Porto Alegre', 'RS'),
('234.567.890-12', 'Rafael Almeida Pereira', 'Premium', '(61) 93210-9876', 'rafael.pereira@email.com', 'Setor Bancário Sul', '33', '70070-120', 'Brasília', 'DF'),
('876.543.210-98', 'Fernanda Rodrigues Lima', 'Premium', '(71) 92109-8765', 'fernanda.lima@email.com', 'Rua do Comércio', '189', '40010-110', 'Salvador', 'BA'),
('543.210.987-65', 'Pedro Henrique Ferreira', 'Basic', '(81) 91098-7654', 'pedro.ferreira@email.com', 'Avenida Boa Viagem', '456', '51020-300', 'Recife', 'PE'),
('210.987.654-32', 'Mariana Santos Oliveira', 'Premium', '(91) 90987-6543', 'mariana.oliveira@email.com', 'Travessa da Paz', '78', '66010-140', 'Belém', 'PA'),
('987.210.543-21', 'Lucas Andrade Silveira', 'Premium', '(48) 99876-5432', 'lucas.silveira@email.com', 'Rua das Palmeiras', '212', '88010-100', 'Florianópolis', 'SC'),
('456.321.789-09', 'Camila Ribeiro Martins', 'Basic', '(62) 98765-4321', 'camila.martins@email.com', 'Avenida Anhanguera', '345', '74010-010', 'Goiânia', 'GO'),
('321.789.456-54', 'Ricardo Mendes Alves', 'Basic', '(85) 97654-3210', 'ricardo.alves@email.com', 'Rua do Mercado', '567', '60010-100', 'Fortaleza', 'CE'),
('654.987.321-87', 'Amanda Costa Cardoso', 'Premium', '(98) 96543-2109', 'amanda.cardoso@email.com', 'Avenida dos Estados', '890', '65010-100', 'São Luís', 'MA'),
('234.876.543-76', 'Gustavo Pinto Teixeira', 'Basic', '(27) 95432-1098', 'gustavo.teixeira@email.com', 'Rua do Porto', '234', '29010-100', 'Vitória', 'ES'),
('876.234.567-65', 'Larissa Campos Barbosa', 'Premium', '(92) 94321-0987', 'larissa.barbosa@email.com', 'Avenida Eduardo Ribeiro', '678', '69010-100', 'Manaus', 'AM'),
('543.876.210-43', 'Bruno Santos Melo', 'Premium', '(83) 93210-9876', 'bruno.melo@email.com', 'Rua das Trincheiras', '456', '58010-100', 'João Pessoa', 'PB'),
('210.543.987-32', 'Isabella Oliveira Cruz', 'Basic', '(68) 92109-8765', 'isabella.cruz@email.com', 'Avenida Ceará', '123', '69900-100', 'Rio Branco', 'AC'),
('987.654.543-21', 'Matheus Rodrigues Nunes', 'Basic', '(95) 91098-7654', 'matheus.nunes@email.com', 'Rua Central', '789', '69300-100', 'Boa Vista', 'RR'),
('456.210.987-10', 'Sophia Almeida Santos', 'Premium', '(86) 90987-6543', 'sophia.santos@email.com', 'Avenida Presidente Vargas', '456', '64010-100', 'Teresina', 'PI'),
('321.654.210-98', 'Gabriel Costa Oliveira', 'Basic', '(84) 99876-5432', 'gabriel.oliveira@email.com', 'Rua da Concórdia', '234', '59010-100', 'Natal', 'RN');

-- Inserções de Pagamentos para a Tabela Padaria.pagamento
INSERT INTO Padaria.pagamento VALUES 
('123.456.789-01', 'Cartão de Crédito', 1),
('987.654.321-09', 'Cartão de Débito', 2),
('456.789.123-45', 'PIX', 3),
('321.654.987-65', 'Dinheiro', 4),
('654.321.987-54', 'Cartão de Crédito', 5),
('234.567.890-12', 'PIX', 6),
('876.543.210-98', 'Cartão de Débito', 7),
('543.210.987-65', 'Vale Alimentação', 8),
('210.987.654-32', 'Cartão de Crédito', 9),
('987.210.543-21', 'PIX', 10),
('456.321.789-09', 'Dinheiro', 11),
('321.789.456-54', 'Cartão de Débito', 12),
('654.987.321-87', 'Vale Alimentação', 13),
('234.876.543-76', 'Cartão de Crédito', 14),
('876.234.567-65', 'PIX', 15),
('543.876.210-43', 'Vale Alimentação', 16),
('210.543.987-32', 'Cartão de Débito', 17),
('987.654.543-21', 'Dinheiro', 18),
('456.210.987-10', 'Cartão de Crédito', 19),
('321.654.210-98', 'PIX', 20);

-- Inserções de Produto_Constituido_Ingrediente
INSERT INTO Padaria.produto_constituido_ingrediente VALUES 
-- Pão Francês (id: 1)
(1, 1, 1000),  -- Farinha de Trigo: 1kg
(1, 2, 30),    -- Fermento: 30g
(1, 3, 20),    -- Sal: 20g
(1, 7, 50),    -- Manteiga: 50g

-- Pão de Leite (id: 2)
(2, 1, 500),   -- Farinha de Trigo: 500g
(2, 2, 20),    -- Fermento: 20g
(2, 4, 50),    -- Açúcar: 50g
(2, 5, 200),   -- Leite: 200ml
(2, 6, 2),     -- Ovos: 2 unidades

-- Croissant (id: 3)
(3, 1, 300),   -- Farinha de Trigo: 300g
(3, 7, 200),   -- Manteiga: 200g
(3, 3, 5),     -- Sal: 5g
(3, 2, 15),    -- Fermento: 15g

-- Bolo de Chocolate (id: 4)
(4, 1, 400),   -- Farinha de Trigo: 400g
(4, 8, 100),   -- Chocolate em Pó: 100g
(4, 4, 300),   -- Açúcar: 300g
(4, 6, 4),     -- Ovos: 4 unidades
(4, 5, 250),   -- Leite: 250ml

-- Pão de Queijo (id: 5)
(5, 9, 500),   -- Polvilho: 500g
(5, 10, 300),  -- Queijo: 300g
(5, 6, 3),     -- Ovos: 3 unidades
(5, 5, 200),   -- Leite: 200ml
(5, 7, 100),   -- Manteiga: 100g

-- Baguete (id: 6)
(6, 1, 500),   -- Farinha de Trigo: 500g
(6, 2, 25),    -- Fermento: 25g
(6, 3, 10),    -- Sal: 10g

-- Sonho (id: 7)
(7, 1, 300),   -- Farinha de Trigo: 300g
(7, 2, 15),    -- Fermento: 15g
(7, 4, 100),   -- Açúcar: 100g
(7, 6, 2),     -- Ovos: 2 unidades
(7, 13, 200),  -- Leite Condensado: 200g

-- Rosca Doce (id: 8)
(8, 1, 400),   -- Farinha de Trigo: 400g
(8, 2, 20),    -- Fermento: 20g
(8, 4, 150),   -- Açúcar: 150g
(8, 6, 3),     -- Ovos: 3 unidades
(8, 14, 100),  -- Frutas Secas: 100g

-- Torta de Frango (id: 9)
(9, 1, 300),   -- Farinha de Trigo: 300g
(9, 7, 150),   -- Manteiga: 150g
(9, 6, 2),     -- Ovos: 2 unidades
(9, 12, 200),  -- Creme de Leite: 200g

-- Cookie (id: 10)
(10, 1, 250),  -- Farinha de Trigo: 250g
(10, 4, 200),  -- Açúcar: 200g
(10, 7, 125),  -- Manteiga: 125g
(10, 8, 50);   -- Chocolate em Pó: 50g

-- Inserções de Fornece_Item_Estoque
INSERT INTO Padaria.fornece_item_estoque VALUES 
-- Farinha & Cia Ltda
('12.345.678/0001-90', 21, 500, 89.90),   -- Farinha de Trigo: 500kg
('12.345.678/0001-90', 35, 200, 129.90), -- Farinha Integral: 200kg
('12.345.678/0001-90', 31, 100, 95.50),  -- Farinha de Milho: 100kg

-- Padaria Ingredientes Atacado
('23.456.789/0001-81', 22, 50, 85.90),    -- Fermento: 50kg
('23.456.789/0001-81', 23, 100, 45.90),   -- Sal: 100kg
('23.456.789/0001-81', 37, 30, 62.50),   -- Amido de Milho: 30kg

-- Doces e Massas Distribuidora
('34.567.890/0001-72', 28, 25, 89.90),    -- Chocolate em Pó: 25kg
('34.567.890/0001-72', 33, 100, 99.90),  -- Leite Condensado: 100 caixas
('34.567.890/0001-72', 39, 20, 79.90),   -- Cacau em Pó: 20kg

-- Açúcar e Mel Comércio
('45.678.901/0001-63', 24, 400, 85.50),   -- Açúcar: 400kg
('45.678.901/0001-63', 38, 10, 45.90),   -- Essência de Baunilha: 10L
('45.678.901/0001-63', 40, 15, 59.90),   -- Canela em Pó: 15kg

-- Trigo Dourado Importadora
('56.789.012/0001-54', 29, 200, 95.90),   -- Polvilho: 200kg
('56.789.012/0001-54', 36, 150, 75.90),  -- Gordura Vegetal: 150kg

-- Confeitaria Primavera Atacado
('67.890.123/0001-45', 34, 50, 199.90),  -- Frutas Secas: 50kg
('67.890.123/0001-45', 32, 100, 89.90),  -- Creme de Leite: 100 caixas

-- Ovos e Laticínios Sul
('89.012.345/0001-27', 26, 500, 199.90),  -- Ovos: 500 dúzias
('89.012.345/0001-27', 25, 300, 159.90),  -- Leite: 300L
('89.012.345/0001-27', 27, 200, 189.90),  -- Manteiga: 200kg
('89.012.345/0001-27', 30, 150, 299.90); -- Queijo: 150kg

-- Inserções de Cliente_Gera_Venda
INSERT INTO Padaria.cliente_gera_venda VALUES 
('123.456.789-01', 1),  -- Maria Silva Santos - Venda de R$ 35,50
('987.654.321-09', 2),  -- João Pedro Oliveira - Venda de R$ 22,75
('456.789.123-45', 3),  -- Ana Beatriz Rocha - Venda de R$ 47,30
('321.654.987-65', 4),  -- Carlos Eduardo Souza - Venda de R$ 18,90
('654.321.987-54', 5),  -- Juliana Martins Costa - Venda de R$ 62,40
('234.567.890-12', 6),  -- Rafael Almeida Pereira - Venda de R$ 15,60
('876.543.210-98', 7),  -- Fernanda Rodrigues Lima - Venda de R$ 53,20
('543.210.987-65', 8),  -- Pedro Henrique Ferreira - Venda de R$ 29,85
('210.987.654-32', 9),  -- Mariana Santos Oliveira - Venda de R$ 41,75
('987.210.543-21', 10), -- Lucas Andrade Silveira - Venda de R$ 33,60
('456.321.789-09', 11), -- Camila Ribeiro Martins - Venda de R$ 57,90
('321.789.456-54', 12), -- Ricardo Mendes Alves - Venda de R$ 26,40
('654.987.321-87', 13), -- Amanda Costa Cardoso - Venda de R$ 49,50
('234.876.543-76', 14), -- Gustavo Pinto Teixeira - Venda de R$ 19,75
('876.234.567-65', 15), -- Larissa Campos Barbosa - Venda de R$ 38,60
('543.876.210-43', 16), -- Bruno Santos Melo - Venda de R$ 45,30
('210.543.987-32', 17), -- Isabella Oliveira Cruz - Venda de R$ 21,85
('987.654.543-21', 18), -- Matheus Rodrigues Nunes - Venda de R$ 55,20
('456.210.987-10', 19), -- Sophia Almeida Santos - Venda de R$ 32,40
('321.654.210-98', 20); -- Gabriel Costa Oliveira - Venda de R$ 67,50

-- Inserções para a tabela Padaria.item_venda
INSERT INTO Padaria.item_venda VALUES
-- Venda 1 (35.50) - Pão Francês e Bolo de Chocolate
(1, 1),  -- Pão Francês
(4, 1),  -- Bolo de Chocolate

-- Venda 2 (22.75) - Croissant e Pão de Queijo
(3, 2),  -- Croissant
(5, 2),  -- Pão de Queijo

-- Venda 3 (47.30) - Torta de Frango
(9, 3),  -- Torta de Frango

-- Venda 4 (18.90) - Pão de Leite e Cookie
(2, 4),  -- Pão de Leite
(10, 4), -- Cookie

-- Venda 5 (62.40) - Bolo de Cenoura e Quiche de Legumes
(14, 5), -- Bolo de Cenoura
(17, 5), -- Quiche de Legumes

-- Venda 6 (15.60) - Sonho e Brigadeiro
(7, 6),  -- Sonho
(19, 6), -- Brigadeiro

-- Venda 7 (53.20) - Bolo de Chocolate e Rosca Doce
(4, 7),  -- Bolo de Chocolate
(8, 7),  -- Rosca Doce

-- Venda 8 (29.85) - Pão Integral e Coxinha
(15, 8), -- Pão Integral
(12, 8), -- Coxinha

-- Venda 9 (41.75) - Pão de Forma e Empada
(18, 9), -- Pão de Forma
(13, 9), -- Empada

-- Venda 10 (33.60) - Baguete e Broa de Milho
(6, 10),  -- Baguete
(11, 10), -- Broa de Milho

-- Venda 11 (57.90) - Quiche de Legumes e Pastel de Nata
(17, 11), -- Quiche de Legumes
(20, 11), -- Pastel de Nata

-- Venda 12 (26.40) - Esfiha e Cookie
(16, 12), -- Esfiha
(10, 12), -- Cookie

-- Venda 13 (49.50) - Torta de Frango
(9, 13),  -- Torta de Frango

-- Venda 14 (19.75) - Pão de Queijo e Sonho
(5, 14),  -- Pão de Queijo
(7, 14),  -- Sonho

-- Venda 15 (38.60) - Pão de Leite e Empada
(2, 15),  -- Pão de Leite
(13, 15), -- Empada

-- Venda 16 (45.30) - Bolo de Cenoura
(14, 16), -- Bolo de Cenoura

-- Venda 17 (21.85) - Croissant e Brigadeiro
(3, 17),  -- Croissant
(19, 17), -- Brigadeiro

-- Venda 18 (55.20) - Bolo de Chocolate e Pão Integral
(4, 18),  -- Bolo de Chocolate
(15, 18), -- Pão Integral

-- Venda 19 (32.40) - Rosca Doce e Esfiha
(8, 19),  -- Rosca Doce
(16, 19), -- Esfiha

-- Venda 20 (67.50) - Torta de Frango e Quiche de Legumes
(9, 20),  -- Torta de Frango
(17, 20); -- Quiche de Legumes
