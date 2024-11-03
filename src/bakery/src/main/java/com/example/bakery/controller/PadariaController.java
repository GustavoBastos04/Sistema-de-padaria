package com.example.bakery.controller;

import com.example.bakery.projections.GeneralProjection;
import com.example.bakery.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("padaria")
public class PadariaController {

    @Autowired
    ClienteRepository repository;
    @GetMapping
    public List<GeneralProjection> getAll(){
        return repository.findAllClientData();
    }
}
