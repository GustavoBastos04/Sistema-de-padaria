SET search_path TO Padaria, public;

CREATE SCHEMA Padaria

CREATE TABLE venda (
    id_venda SERIAL PRIMARY KEY,
    valor NUMERIC(5,2),
    data_de_venda DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE fornecedor (
    cnpj VARCHAR NOT NULL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    telefone VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    logradouro VARCHAR NOT NULL,
    numero VARCHAR NOT NULL,
    cep VARCHAR NOT NULL,
    cidade VARCHAR NOT NULL,
    uf VARCHAR NOT NULL
);

CREATE TABLE item_estoque (
    id_item SERIAL PRIMARY KEY
);



CREATE TABLE ingrediente (
    id_ingrediente SERIAL PRIMARY KEY,
    estoque_id_item INT NOT NULL,
    FOREIGN KEY (estoque_id_item) REFERENCES item_estoque(id_item)
);

CREATE TABLE cliente (
    cpf VARCHAR NOT NULL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    tipo_de_assinatura VARCHAR NOT NULL,
    telefone VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    logradouro VARCHAR NOT NULL,
    numero VARCHAR NOT NULL,
    cep VARCHAR NOT NULL,
    cidade VARCHAR NOT NULL,
    uf VARCHAR NOT NULL
);

CREATE TABLE produto (
    id_produto SERIAL PRIMARY KEY,
    nome VARCHAR NOT NULL,
    valor NUMERIC(5,2) NOT NULL,
    quantidade INT NOT NULL,
    estoque_id_item INT NOT NULL,
    cliente_cpf VARCHAR,
    FOREIGN KEY (estoque_id_item) REFERENCES item_estoque(id_item),
); 

CREATE TABLE pagamento (
    cliente_cpf VARCHAR NOT NULL PRIMARY KEY,
    tipo VARCHAR NOT NULL,
    FOREIGN KEY (cliente_cpf) REFERENCES cliente(cpf)
);

CREATE TABLE produto_constituido_ingrediente (
    produto_id_produto INT NOT NULL,
    ingrediente_id_ingrediente INT NOT NULL,
    quantidade INT NOT NULL,
    CONSTRAINT PK_produto_const_ingrediente PRIMARY KEY (produto_id_produto, ingrediente_id_ingrediente),
    FOREIGN KEY (produto_id_produto) REFERENCES produto(id_produto),
    FOREIGN KEY (ingrediente_id_ingrediente) REFERENCES ingrediente(id_ingrediente)
);

CREATE TABLE fornece_item_estoque (
    fornecedor_cnpj VARCHAR NOT NULL,
    estoque_id_item INT NOT NULL,
    quantidade INT NOT NULL,
    preco NUMERIC(5,2) NOT NULL,
    CONSTRAINT PK_fornece_item_estoque PRIMARY KEY (fornecedor_cnpj, estoque_id_item),
    FOREIGN KEY (fornecedor_cnpj) REFERENCES fornecedor(cnpj),
    FOREIGN KEY (estoque_id_item) REFERENCES item_estoque(id_item)
);

CREATE TABLE cliente_gera_venda (
    cliente_cpf VARCHAR NOT NULL,
    venda_id_venda INT NOT NULL,
    CONSTRAINT PK_cliente_gera_venda PRIMARY KEY (cliente_cpf, venda_id_venda),
    FOREIGN KEY (cliente_cpf) REFERENCES cliente(cpf),
    FOREIGN KEY (venda_id_venda) REFERENCES venda(id_venda)
);

CREATE TABLE item_venda (
    produto_id_produto INT NOT NULL,
    venda_id_venda INT NOT NULL,
    CONSTRAINT PK_item_venda PRIMARY KEY (produto_id_produto, venda_id_venda),
    FOREIGN KEY (produto_id_produto) REFERENCES produto(id_produto),
    FOREIGN KEY (venda_id_venda) REFERENCES venda(id_venda)
);

