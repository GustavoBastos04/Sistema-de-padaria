package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.*;
import com.example.bakery.entities.*;
import com.example.bakery.repositories.entities.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class VendaController {
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

}
