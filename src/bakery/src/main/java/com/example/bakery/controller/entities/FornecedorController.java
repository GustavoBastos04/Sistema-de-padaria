package com.example.bakery.controller.entities;

import com.example.bakery.dtos.functionalitiesdtos.FornecedorDTO;
import com.example.bakery.entities.*;
import com.example.bakery.repositories.entities.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("padaria")
public class FornecedorController {
    // FORNECEDOR
    @Autowired
    FornecedorRepository supplierRepository;
    @GetMapping("fornecedor")
    public List<FornecedorDTO> getSuppliers(){
        return supplierRepository.getFornecedores();
    }
}
