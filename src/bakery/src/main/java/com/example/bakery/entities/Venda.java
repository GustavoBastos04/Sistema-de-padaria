package com.example.bakery.entities;

import com.example.bakery.dtos.entitydtos.VendaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@Entity(name = "venda")
@Table(name = "venda")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venda;
    private BigDecimal valor;
    private Date data_de_venda;

    public Venda(VendaDTO newSell){
        this.id_venda = newSell.id_venda();
        this.valor = newSell.valor();
        this.data_de_venda = newSell.data_de_venda();
    }
}
