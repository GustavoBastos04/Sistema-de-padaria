package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.fornecedor.FornecedorRequestDTO;
import com.example.bakery.dtos.entitydtos.fornecedor.FornecedorResponseDTO;
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
}
