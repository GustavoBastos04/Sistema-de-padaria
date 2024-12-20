CREATE TABLE endereco (
	cep VARCHAR NOT NULL,
	logradouro VARCHAR NOT NULL,
	cidade VARCHAR NOT NULL,
	uf VARCHAR NOT NULL,
	PRIMARY KEY (cep)
);

CREATE TABLE cliente (
    cpf VARCHAR NOT NULL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    tipo_de_assinatura VARCHAR NOT NULL,
    telefone VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    cep VARCHAR NOT NULL,
    numero VARCHAR NOT NULL,
    FOREIGN KEY (cep) REFERENCES endereco(cep)
);

CREATE TABLE venda (
    id_venda INT PRIMARY KEY,
    valor NUMERIC(5,2),
    data_de_venda DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE produto (
    id_produto INT PRIMARY KEY,
    nome VARCHAR NOT NULL,
    valor NUMERIC(5,2) NOT NULL
); 

CREATE TABLE cliente_gera_venda (
    cliente_cpf VARCHAR NOT NULL,
    venda_id_venda INT NOT NULL,
    CONSTRAINT PK_cliente_gera_venda PRIMARY KEY (cliente_cpf, venda_id_venda),
    FOREIGN KEY (cliente_cpf) REFERENCES cliente(cpf),
    FOREIGN KEY (venda_id_venda) REFERENCES venda(id_venda)
);

CREATE TABLE item_venda (
    id_produto INT NOT NULL,
    id_venda INT NOT NULL,
    CONSTRAINT PK_item_venda PRIMARY KEY (id_produto, id_venda),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
    FOREIGN KEY (id_venda) REFERENCES venda(id_venda)
);

CREATE TABLE pagamento (
	cliente_cpf VARCHAR NOT NULL,
	tipo VARCHAR NOT NULL,
	id_venda INT NOT NULL,
	CONSTRAINT PK_pagamento PRIMARY KEY (cliente_cpf, id_venda),
	FOREIGN KEY (cliente_cpf) REFERENCES cliente(cpf),
	FOREIGN KEY (id_venda) REFERENCES venda(id_venda)
);

CREATE TABLE fornecedor (
    cnpj VARCHAR NOT NULL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    telefone VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    cep VARCHAR NOT NULL,
    numero VARCHAR NOT NULL,
    FOREIGN KEY (cep) REFERENCES endereco(cep)
);

CREATE TABLE ingrediente (
    id_ingrediente INT PRIMARY KEY,
    nome VARCHAR NOT NULL
);

CREATE TABLE fornece_ingrediente (
    fornecedor_cnpj VARCHAR NOT NULL,
    id_ingrediente INT NOT NULL,
    quantidade INT NOT NULL,
    preco NUMERIC(5,2) NOT NULL,
    CONSTRAINT PK_fornece_item_estoque PRIMARY KEY (fornecedor_cnpj, id_ingrediente),
    FOREIGN KEY (fornecedor_cnpj) REFERENCES fornecedor(cnpj),
    FOREIGN KEY (id_ingrediente) REFERENCES ingrediente(id_ingrediente)
);

CREATE TABLE produto_constituido_ingrediente (
    id_produto INT NOT NULL,
    id_ingrediente INT NOT NULL,
    quantidade INT NOT NULL,
    CONSTRAINT PK_produto_const_ingrediente PRIMARY KEY (id_produto, id_ingrediente),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto),
    FOREIGN KEY (id_ingrediente) REFERENCES ingrediente(id_ingrediente)
);

CREATE TABLE estoque (
    id_ingrediente INT PRIMARY KEY,
    quantidade INT NOT NULL,
    data_validade date NOT NULL,
    FOREIGN KEY (id_ingrediente) REFERENCES ingrediente(id_ingrediente)
);

CREATE TABLE produtos_restantes ( 
	id_produto INT NOT NULL PRIMARY KEY,
	quantidade INT NOT NULL,
	FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);
