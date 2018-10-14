package br.com.thecoders.tasktool.Classes;
import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

public class RespostaLogin {

    @SerializedName("accessToken")
    private String tokenAcesso;
    @SerializedName("expiresIn")
    private DateTime expiraEm;
    private Operador usuario;

    public RespostaLogin(String tokenAcesso, DateTime expiraEm, Operador usuario) {
        this.tokenAcesso = tokenAcesso;
        this.expiraEm = expiraEm;
        this.usuario = usuario;
    }

    public String getTokenAcesso() {
        return tokenAcesso;
    }

    public void setTokenAcesso(String tokenAcesso) {
        this.tokenAcesso = tokenAcesso;
    }

    public String getexpiraEm() {
        return expiraEm.toString("dd/MM/yyyy\nHH:mm");
    }

    public void setexpiraEm(DateTime nome) {
        this.expiraEm = nome;
    }

    public Operador getUsuario() {
        return usuario;
    }

    public void setUsuario(Operador usuario) {
        this.usuario = usuario;
    }
}
