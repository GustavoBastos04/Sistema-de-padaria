package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.*;
import com.example.bakery.entities.*;
import com.example.bakery.repositories.entities.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class PagamentoController {
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

}
