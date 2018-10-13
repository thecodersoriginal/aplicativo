package br.com.thecoders.tasktool.Classes;

import org.joda.time.DateTime;

public class Servico
{
    private int id;
    private String descricao;
    private DateTime agendadaPara;
    private DateTime iniciadoEm;
    private DateTime finalizadoEm;
    private Usuario origem;
    private Usuario destino;
    private int dias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAgendadaPara() {
        return agendadaPara.toString("dd/mm/yyyy");
    }

    public void setAgendadaPara(DateTime agendadaPara) {
        this.agendadaPara = agendadaPara;
    }

    public String getIniciadoEm() {
        return iniciadoEm.toString("dd/mm/yyyy");
    }

    public void setIniciadoEm(DateTime iniciadoEm) {
        this.iniciadoEm = iniciadoEm;
    }

    public String getFinalizadoEm() {
        return finalizadoEm.toString("dd/mm/yyyy");
    }

    public void setFinalizadoEm(DateTime finalizadoEm) {
        this.finalizadoEm = finalizadoEm;
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

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}
