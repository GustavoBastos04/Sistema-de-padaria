package com.example.bakery.repositories.entities;

import com.example.bakery.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
