package br.com.thecoders.tasktool.Classes;

import org.joda.time.DateTime;

public class Alerta
{
    private int id;
    private String mensagem;
    private Usuario origem;
    private Usuario destino;
    private DateTime visualizadoEm;

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

    public Usuario getOrigem() {
        return origem;
    }

    public void setOrigem(Usuario origem) {
        this.origem = origem;
    }

    public Usuario getDestino() {
        return destino;
    }

    public void setDestino(Usuario destino) {
        this.destino = destino;
    }

    public String getVisualizadoEm() {
        return visualizadoEm.toString("dd/mm/yyyy HH:mm");
    }

    public void setVisualizadoEm(DateTime visualizadoEm) {
        this.visualizadoEm = visualizadoEm;
    }
}
