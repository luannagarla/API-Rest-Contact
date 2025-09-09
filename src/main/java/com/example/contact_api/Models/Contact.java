package com.example.contact_api.Models;

public class Contact {
    private int index;
    private String nome;
    private String telefone;
    private String email;

    public Contact(int index, String nome, String email, String telefone) {
        this.index = index;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIndex() { return index; }
    public void setId(int index) { this.index = index; }

    public String getName() { return nome; }
    public void setName(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}