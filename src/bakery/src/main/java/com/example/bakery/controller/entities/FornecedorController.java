package com.example.bakery.controller.entities;

import com.example.bakery.dtos.entitydtos.FornecedorRequestDTO;
import com.example.bakery.dtos.functionalitiesdtos.FornecedorDTO;
import com.example.bakery.entities.*;
import com.example.bakery.repositories.entities.EnderecoRepository;
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
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping("fornecedor")
    public List<FornecedorDTO> getSuppliers(){
        return supplierRepository.getFornecedores();
    }

    @PostMapping("fornecedor")
    public void saveSuppliers(@RequestBody FornecedorRequestDTO fornecedorRequestDTO){
        Endereco endereco = new Endereco(fornecedorRequestDTO);
        enderecoRepository.save(endereco);

        Fornecedor fornecedor = new Fornecedor(fornecedorRequestDTO);
        fornecedorRepository.save(fornecedor);
        return;
    }
}
