package com.example.a201619060353.atividadeextra2.dados;

public class Usuario {
    private int id;
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public String getLogin(){
        return login;
    }

    public String getSenha(){
        return senha;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
