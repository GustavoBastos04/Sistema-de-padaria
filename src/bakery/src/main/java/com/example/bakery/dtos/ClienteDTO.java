package com.example.bakery.dtos;

import com.example.bakery.projections.GeneralProjection;

// DTO = Data Transfer Object
public class ClienteDTO {

    private String cpf;
    private String nome;
    private String tipo_de_assinatura;
    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String uf;

    public ClienteDTO(String cpf, String nome, String tipo_de_assinatura,
                      String telefone, String email, String logradouro,
                      String numero, String cep, String cidade, String uf) {
        this.cpf = cpf;
        this.nome = nome;
        this.tipo_de_assinatura = tipo_de_assinatura;
        this.telefone = telefone;
        this.email = email;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public ClienteDTO(GeneralProjection projection) {
        cpf = projection.getClienteCpf();
        nome = projection.getClienteNome();
        tipo_de_assinatura = projection.getClienteTipoAssinatura();
        telefone = projection.getClienteTelefone();
        email = projection.getClienteEmail();
        logradouro = projection.getClienteLogradouro();
        numero = projection.getClienteNumero();
        cep = projection.getClienteCep();
        cidade = projection.getClienteCidade();
        uf = projection.getClienteUf();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo_de_assinatura() {
        return tipo_de_assinatura;
    }

    public void setTipo_de_assinatura(String tipo_de_assinatura) {
        this.tipo_de_assinatura = tipo_de_assinatura;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
