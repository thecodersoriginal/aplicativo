package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

public class Usuario
{
    @SerializedName("id")
    private int id;
    @SerializedName("login")
    private String login;
    @SerializedName("name")
    private String nome;
    @SerializedName("phone")
    private String telefone;
    @SerializedName("email")
    private String email;
    private String senha;
    private String chave;
    @SerializedName("type")
    private String tipo;

    public Usuario(int id, String login, String nome, String telefone, String email, String senha, String chave, String tipo)
    {
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.chave = chave;
        this.tipo = tipo;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getChave()
    {
        return chave;
    }

    public void setChave(String chave)
    {
        this.chave = chave;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    @Override
    public String toString()
    {
        return nome;
    }
}
