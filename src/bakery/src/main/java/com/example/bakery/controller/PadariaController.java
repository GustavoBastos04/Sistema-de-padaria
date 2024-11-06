package com.example.bakery.controller;

import com.example.bakery.dtos.entitydtos.*;
import com.example.bakery.dtos.entitydtos.cliente.ClienteRequestDTO;
import com.example.bakery.dtos.entitydtos.cliente.ClienteResponseDTO;
import com.example.bakery.dtos.entitydtos.fornecedor.FornecedorRequestDTO;
import com.example.bakery.dtos.entitydtos.fornecedor.FornecedorResponseDTO;
import com.example.bakery.entities.*;
import com.example.bakery.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class PadariaController {

    // CLIENTE
    @Autowired
    ClienteRepository clientRepository;
    // Exemplo de uso: localhost:8080/padaria/cliente/
    @GetMapping("cliente")
    public List<ClienteResponseDTO> getClients(){
        List<ClienteResponseDTO> clientList = clientRepository.getClientes().stream().map(ClienteResponseDTO::new).toList();
        return clientList;
    }
    @PostMapping("cliente")
    public void saveClient(@RequestBody ClienteRequestDTO newClient){
        Cliente clientData = new Cliente(newClient);
        clientRepository.save(clientData);
        return;
    }

    // FORNECEDOR
    @Autowired
    FornecedorRepository supplierRepository;
    @GetMapping("fornecedor")
    public List<FornecedorResponseDTO> getSuppliers(){
        List<FornecedorResponseDTO> supplierList = supplierRepository.getFornecedores().stream().map(FornecedorResponseDTO::new).toList();
        return supplierList;
    }
    @PostMapping("fornecedor")
    public void saveSupplier(@RequestBody FornecedorRequestDTO newFornecedor){
        Fornecedor fornecedorData = new Fornecedor(newFornecedor);
        supplierRepository.save(fornecedorData);
        return;
    }

    // VENDA
    @Autowired
    VendaRepository sellRepository;
    @GetMapping("venda")
    public List<VendaDTO> getSells(){
        List<VendaDTO> sellList = sellRepository.getVendas().stream().map(VendaDTO::new).toList();
        return sellList;
    }
    @PostMapping("venda")
    public void saveSell(@RequestBody VendaDTO newSell){
        Venda sellData = new Venda(newSell);
        sellRepository.save(sellData);
        return;
    }

    // ITEM DE ESTOQUE
    @Autowired
    ItemEstoqueRepository itemEstoqueRepository;
    @GetMapping("item_de_estoque")
    public List<ItemEstoqueDTO> getItemEstoque(){
        List<ItemEstoqueDTO> itemEstoqueList = itemEstoqueRepository.getItems().stream().map(ItemEstoqueDTO::new).toList();
        return itemEstoqueList;
    }
    @PostMapping("item_de_estoque")
    public void saveItemEstoque(@RequestBody ItemEstoqueDTO newItemEstoque){
        ItemEstoque itemEstoqueData = new ItemEstoque(newItemEstoque);
        itemEstoqueRepository.save(itemEstoqueData);
        return;
    }

    // INGREDIENTE
    @Autowired
    IngredienteRepository ingredienteRepository;
    @GetMapping("ingrediente")
    public List<IngredienteDTO> getIngrediente(){
        List<IngredienteDTO> ingredienteList = ingredienteRepository.getIngredientes().stream().map(IngredienteDTO::new).toList();
        return ingredienteList;
    }
    @PostMapping("ingrediente")
    public void saveIngrediente(@RequestBody IngredienteDTO newIngrediente){
        Ingrediente ingredienteData = new Ingrediente(newIngrediente);
        ingredienteRepository.save(ingredienteData);
        return;
    }

    // PRODUTO
    @Autowired
    ProdutoRepository produtoRepository;
    @GetMapping("produto")
    public List<ProdutoDTO> getProdutos(){
        List<ProdutoDTO> produtosList = produtoRepository.getProdutos().stream().map(ProdutoDTO::new).toList();
        return produtosList;
    }
    @PostMapping("produto")
    public void saveProduto(@RequestBody ProdutoDTO newProduto){
        Produto produtoData = new Produto(newProduto);
        produtoRepository.save(produtoData);
        return;
    }

    // PAGAMENTO
    @Autowired
    PagamentoRepository pagamentoRepository;
    @GetMapping("pagamento")
    public List<PagamentoDTO> getPagamentos(){
        List<PagamentoDTO> pagamentoList = pagamentoRepository.getPagamentos().stream().map(PagamentoDTO::new).toList();
        return pagamentoList;
    }
    @PostMapping("pagamento")
    public void savePagamento(@RequestBody PagamentoDTO newPagamento){
        Pagamento pagamentoData = new Pagamento(newPagamento);
        pagamentoRepository.save(pagamentoData);
        return;
    }

    // RELACIONAMENTO PRODUTO-CONSTITUIDO-INGREDIENTE

}
