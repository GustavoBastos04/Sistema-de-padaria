package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.ForneceItemEstoqueDTO;
import com.example.bakery.entities.ForneceItemEstoque;
import com.example.bakery.repositories.entities.ForneceItemEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class ForneceItemEstoqueController {
    @Autowired
    ForneceItemEstoqueRepository forneceItemEstoqueRepository;

    @GetMapping("fornece-item-estoque")
    public List<ForneceItemEstoqueDTO> getForneceItemEstoque(){
        List<ForneceItemEstoqueDTO> forneceItemEstoqueList = forneceItemEstoqueRepository.getForneceItemEstoque().stream().map(ForneceItemEstoqueDTO::new).toList();
        return forneceItemEstoqueList;
    }
    @PostMapping("fornece-item-estoque")
    public void saveForneceItemEstoque(@RequestBody ForneceItemEstoqueDTO newForneceItemEstoque){
        ForneceItemEstoque forneceItemEstoqueData =  new ForneceItemEstoque(newForneceItemEstoque);
        forneceItemEstoqueRepository.save(forneceItemEstoqueData);
        return;
    }
}
