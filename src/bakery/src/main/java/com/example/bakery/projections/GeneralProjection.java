package com.example.bakery.projections;

import lombok.Getter;

// It's like a filter for the Repository Class queue (but as a single tuple)
public interface GeneralProjection {

    // Cliente
    String getClienteCpf();
    String getClienteNome();
    String getClienteTipoAssinatura();
    String getClienteTelefone();
    String getClienteEmail();
    String getClienteLogradouro();
    String getClienteNumero();
    String getClienteCep();
    String getClienteCidade();
    String getClienteUf();


}
