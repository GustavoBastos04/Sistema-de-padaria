package com.example.bakery.controller.functionalities;

import com.example.bakery.dtos.functionalitiesdtos.LucroDeterminadoPeriodoDTO;
import com.example.bakery.repositories.entities.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.sql.Date;

@RestController
@RequestMapping("padaria")
public class LucroDeterminadoPeriodoController {

    @Autowired
    VendaRepository vendaRepository;

    @GetMapping("lucro-determinado-periodo")
    public List<LucroDeterminadoPeriodoDTO> getLucroDeterminadoPeriodo(@RequestParam Date begin, @RequestParam Date end){
        return vendaRepository.getLucroDeterminadoPeriodo(begin, end);
    }
}
