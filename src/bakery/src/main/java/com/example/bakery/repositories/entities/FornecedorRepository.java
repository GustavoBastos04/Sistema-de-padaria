package com.example.bakery.repositories.entities;

import com.example.bakery.dtos.functionalitiesdtos.FornecedorDTO;
import com.example.bakery.entities.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {

    @Query(nativeQuery = true, value = "SELECT f.cnpj, f.nome, f.telefone, f.email, f.cep, e.logradouro || ', ' || f.numero AS endereco, e.cidade, e.uf FROM fornecedor as f INNER JOIN endereco as e ON f.cep = e.cep;")
    List<FornecedorDTO> getFornecedores();
}
