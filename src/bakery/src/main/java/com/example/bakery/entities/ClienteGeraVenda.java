package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.ClienteGeraVendaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cliente_gera_venda")
@Table(name = "cliente_gera_venda")
@NoArgsConstructor
@AllArgsConstructor
public class ClienteGeraVenda {
    @Id
    private String cliente_cpf;
    private Long venda_id_venda;

    public ClienteGeraVenda(ClienteGeraVendaDTO clienteGeraVendaDTO){
        this.cliente_cpf = clienteGeraVendaDTO.cliente_cpf();
        this.venda_id_venda = clienteGeraVendaDTO.venda_id_venda();
    }

}
