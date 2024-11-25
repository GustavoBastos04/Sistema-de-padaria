package com.example.bakery.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity(name = "estoque")
@Table(name = "estoque")
@NoArgsConstructor
@AllArgsConstructor
public class Estoque {
    @Id
    private Long id_ingrediente;
    private Long quantidade;
    private Date data_validade;
}
