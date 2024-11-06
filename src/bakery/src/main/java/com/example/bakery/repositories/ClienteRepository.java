package com.example.bakery.repositories;

import com.example.bakery.entities.Cliente;
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
    
    // Consulta para obter clientes com desconto baseado no tipo de assinatura
    @Query(nativeQuery = true, value = """
        SELECT 
            c.nome,
            c.cpf,
            SUM(v.valor) AS totalGasto,
            CASE 
                WHEN c.tipo_de_assinatura = 'Premium' THEN SUM(v.valor) * 0.10
                WHEN c.tipo_de_assinatura = 'Basic' THEN SUM(v.valor) * 0.05
                ELSE 0
            END AS desconto,
            SUM(v.valor) - CASE 
                WHEN c.tipo_de_assinatura = 'Premium' THEN SUM(v.valor) * 0.10
                WHEN c.tipo_de_assinatura = 'Basic' THEN SUM(v.valor) * 0.05
                ELSE 0
            END AS totalComDesconto
        FROM
            cliente AS c
        JOIN
            cliente_gera_venda AS cv ON c.cpf = cv.cliente_cpf
        JOIN
            venda AS v ON cv.venda_id_venda = v.id_venda
        GROUP BY
            c.cpf, c.nome
        """)
    List<Cliente> findClientesComDesconto();
}

