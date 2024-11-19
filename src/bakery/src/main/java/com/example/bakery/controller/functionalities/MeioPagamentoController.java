package com.example.bakery.controller.functionalities;

import com.example.bakery.dtos.functionalitiesdtos.MeioPagamentoDTO;
import com.example.bakery.repositories.entities.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class MeioPagamentoController {
    @Autowired
    PagamentoRepository pagamentoRepository;

    @GetMapping("meio-pagamento")
    public List<MeioPagamentoDTO> getMeioPagamento(){
        return pagamentoRepository.getRelatorioMeioPagamento();
    }
}
