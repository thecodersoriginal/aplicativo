package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

public class Operador {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String nome;
    @SerializedName("email")
    private String email;
    @SerializedName("type")
    private String tipo;

    public Operador(int id, String nome, String email, String tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
