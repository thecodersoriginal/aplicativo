package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

public class PedidoLogin {

    @SerializedName("username")
    private String nomeUsuario;
    @SerializedName("password")
    private String senha;

    public PedidoLogin(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
