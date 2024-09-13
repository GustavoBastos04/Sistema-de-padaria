# Trabalho Prático
## Nome dos integrantes: 

- Gustavo Bastos de Souza - 14576642

- Gustavo Henriques Vieira - 14713982

- Kaique de Jesus Pessoa Santos - 14677144

- Renan Bezerra Guimarães - 14605640

## ✏️ Mini mundo: Padaria
Sistema de padaria que registra assinaturas de clientes (que permitem descontos no ato do pagamento) e seus dados de cadastro (Nome, CPF, Endereço, E-mail e Telefone). Ao realizar um pedido, o cliente escolhe um ou mais produtos, contendo suas informações (Valor, Quantidade e Nome), sendo esses produtos constituídos por ingredientes da receita do produto, que informa a quantidade necessária de tal produto em tal receita. Esses produtos também devem ter seus ingredientes disponíveis estocados, bem como é preciso saber suas informações (Nome, Valor, Validade, Marca e Quantidade). Um pedido do cliente contém um ou mais itens  de venda, e estes compõem uma venda, que possui suas próprias informações (Valor e Data da venda). Após a venda, o cliente paga por um meio que é registrado no sistema para aquela determinada venda.

## 📌 Funcionalidades:

🚩*Calcular descontos para clientes cadastrados: O cliente cadastrado ganha um desconto sobre o gasto total;*  

🚩*Gerar relatório de lucro geral e para cada produto;*

🚩*Gerar relatório de vendas e meios de pagamentos;*

🚩*Estimar quantos ingredientes estão disponíveis no estoque em um dado momento.*


## ✏️ Requisito de dados: 
Uma padaria quer construir um sistema para armazenar informações pertinentes para melhorar os processos do negócio e a lucratividade. O cliente cadastrado no sistema da padaria possui o atributo de CPF como principal identificador, além do seu nome, número de telefone, e-mail e a informação composta de seu endereço. Esse cliente compra um produto, que possui um identificador único, nome, valor unitário e quantidade disponível nas prateleiras do estabelecimento. O produto consome os ingredientes estocados, dados por um identificador único, nome, quantidade disponível, valor unitário, validade e marca. O produto é constituído por ingredientes de uma receita, com a quantidade de cada produto. O cliente então realiza um pagamento, caracterizado pelo seu formato, e esse pagamento é com base no valor de uma venda. Uma venda possui um identificador único, valor total e data de processamento da venda. A venda é constituída por um item de venda, gerado com base no produto.