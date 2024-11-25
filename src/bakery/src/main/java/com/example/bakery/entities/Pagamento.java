package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.PagamentoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity(name = "pagamento")
@Table(name = "pagamento")
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {
    @Id
    private String cliente_cpf;
    private Long id_venda;
    private String tipo;

    public Pagamento(PagamentoDTO pagamento){
        this.cliente_cpf = pagamento.cliente_cpf();
        this.id_venda = pagamento.id_venda();
        this.tipo = pagamento.tipo();
    }}
