package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.*;
import com.example.bakery.entities.*;
import com.example.bakery.repositories.entities.ItemEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class ItemEstoqueController {
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
}
