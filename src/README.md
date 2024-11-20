<h1>Tutorial para uso:</h1>
<ul>
<li>no Postgres, criar database "padaria"</li>
<li>Criação das tuplas exatamente como <a href="./bakery/tabelas.txt">tabelas.txt</a></li>
<li>Criação das tuplas exatamente como <a href="./bakery/insercao.txt">insercao.txt</a></li>
<li>Em Sistema-de-padaria/src/bakery/src/main/resources/application.properties, deve estar <a href="./bakery/application-properties.txt">Desse jeito</a></li>
<li>Agora é só dar run no projeto!</li>
</ul>
<h1>GETs e Posts</h1>
<ul>
<li>cliente [GET][POST]</li>
<li>fornecedor [GET][POST]</li>
<li>fornece-item-estoque [GET][POST]</li>
<li>ingrediente [GET][POST]</li>
<li>item_de_estoque [GET][POST]</li>
<li>pagamento [GET][POST]</li>
<li>produto-constituido-ingrediente [GET][POST]</li>
<li>produto [GET][POST]</li>
<li>venda [GET][POST]</li>
<li>desconto-cliente [GET]</li>
<li>estoque-atual-ingrediente [GET]</li>
<li>[Inativo] lucro-geral-venda [GET]</li>
<li>[Inativo] lucro-geralproduto [GET]</li>
<li>meio-pagamento [GET]</li>
<li>produtos-restantes [GET]</li>
</ul>
<h1>Importante</h1>
<ul>
<li>Siga <strong>estritamente</strong> as intruções indicadas, a aplicação é muito sensível a alteração de nomes de banco de dados, relações e atributos</li>
<li>GET e POSTs devem ser devolvidos em JSON. Esteja ciente ao resgatar dados e principalmente ao inserir</li>
<li>Algumas funcionalidades estão indisponíveis no momento dado que o banco de dados está em fase de alterações</li>
</ul>

<h1>Pendências:</h1>
<ul>
<li>Funcionalidade: Lucro Geral por Venda.  adicionar a Query em VendaRepository e "descomentar" em LucroGeralVendaController</li>
<li>Funcionalidade: Lucro por produto.  adicionar a Query em VendaRepository e "descomentar" em LucroProdutoController</li>
<li>Funcionalidade: fazer tudo de lucro em determinado período (lidar com passada de parâmetros)</li>
</ul>
