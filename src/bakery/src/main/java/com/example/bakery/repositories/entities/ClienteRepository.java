package com.example.bakery.repositories.entities;

import com.example.bakery.entities.Cliente;
import com.example.bakery.dtos.functionalitiesdtos.DescontoClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
// Native Queries that we want to do in SQL DB
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    @Query(nativeQuery = true, value = "SELECT * FROM cliente;")
    List<Cliente> getClientes();

    @Query(nativeQuery = true, value =
            "SELECT * FROM cliente where cliente.tipo_de_assinatura = :tipo_de_assinatura")

    List<Cliente> findClientByType(String tipo_de_assinatura);

    @Query(nativeQuery = true, value= """
-- Desconto para Cliente Cadastrado
SELECT
    c.nome,
    c.cpf,
    SUM(v.valor) AS total_gasto,                            -- mostra o total gasto antes do desconto
    CASE
        WHEN c.tipo_de_assinatura = 'Premium' THEN SUM(v.valor) * 0.10  -- desconto de 10% para clientes Premium
        WHEN c.tipo_de_assinatura = 'Basic' THEN SUM(v.valor) * 0.05    -- desconto de 5% para clientes Basic
        ELSE 0                                                          -- sem desconto para outros tipos
    END AS desconto,
    SUM(v.valor) - CASE
        WHEN c.tipo_de_assinatura = 'Premium' THEN SUM(v.valor) * 0.10  -- valor final após desconto de 10% para Premium
        WHEN c.tipo_de_assinatura = 'Basic' THEN SUM(v.valor) * 0.05    -- valor final após desconto de 5% para Basic
        ELSE 0                                                          -- sem desconto para outros tipos
    END AS total_com_desconto
FROM
    cliente AS c
JOIN
    cliente_gera_venda AS cv ON c.cpf = cv.cliente_cpf
JOIN
    venda AS v ON cv.venda_id_venda = v.id_venda
GROUP BY
    c.cpf, c.nome;""")
    List<DescontoClienteDTO> getDescontoCliente();
}

