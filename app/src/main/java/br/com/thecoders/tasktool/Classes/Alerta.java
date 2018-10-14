package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

public class Alerta
{
    @SerializedName("id")
    private int id;
    @SerializedName("message")
    private String mensagem;
    @SerializedName("senderId")
    private int idOrigem;
    @SerializedName("receiverId")
    private String idDestino;
    @SerializedName("senderName")
    private String NomeOrigem;
    @SerializedName("receiverName")
    private String NomeDestino;
    @SerializedName("readAt")
    private DateTime visualizadoEm;

    public Alerta(int id, String mensagem, int idOrigem, String idDestino, String nomeOrigem, String nomeDestino, DateTime visualizadoEm) {
        this.id = id;
        this.mensagem = mensagem;
        this.idOrigem = idOrigem;
        this.idDestino = idDestino;
        NomeOrigem = nomeOrigem;
        NomeDestino = nomeDestino;
        this.visualizadoEm = visualizadoEm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getIdOrigem() {
        return idOrigem;
    }

    public void setIdOrigem(int idOrigem) {
        this.idOrigem = idOrigem;
    }

    public String getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(String idDestino) {
        this.idDestino = idDestino;
    }

    public String getNomeOrigem() {
        return NomeOrigem;
    }

    public void setNomeOrigem(String nomeOrigem) {
        NomeOrigem = nomeOrigem;
    }

    public String getNomeDestino() {
        return NomeDestino;
    }

    public void setNomeDestino(String nomeDestino) {
        NomeDestino = nomeDestino;
    }

    public String getVisualizadoEm()
    {
        return visualizadoEm.toString("dd/mm/yyyy HH:mm");
    }

    public void setVisualizadoEm(DateTime visualizadoEm)
    {
        this.visualizadoEm = visualizadoEm;
    }
}
