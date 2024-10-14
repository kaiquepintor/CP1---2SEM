package br.com.fiap.model;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;

    // Construtores
    public Cliente() {}

    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Método sobrescrito
    @Override
    public String toString() {
        return "CLIENTE - ID: " + id + " | NOME: " + nome + " | EMAIL: " + email + " | TELEFONE: " + telefone;
    }
}
