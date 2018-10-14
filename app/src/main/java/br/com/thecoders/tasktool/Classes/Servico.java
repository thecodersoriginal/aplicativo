package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.util.ArrayList;

public class Servico
{

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String descricao;
    @SerializedName("scheduledAt")
    private DateTime agendadaPara;
    @SerializedName("startedAt")
    private DateTime iniciadoEm;
    @SerializedName("finishedAt")
    private DateTime finalizadoEm;
    @SerializedName("senderId")
    private int idOrigem;
    @SerializedName("receiverId")
    private String idDestino;
    @SerializedName("senderName")
    private String NomeOrigem;
    @SerializedName("receiverName")
    private String NomeDestino;
    @SerializedName("repeatInDays")
    private int dias;
    @SerializedName("equipments")
    private ArrayList<ServicoEquipamento> servicoEquipamento;

    public Servico(int id, String descricao, DateTime agendadaPara, DateTime iniciadoEm, DateTime finalizadoEm, int idOrigem, String idDestino, String nomeOrigem, String nomeDestino, int dias, ArrayList<ServicoEquipamento> servicoEquipamento) {
        this.id = id;
        this.descricao = descricao;
        this.agendadaPara = agendadaPara;
        this.iniciadoEm = iniciadoEm;
        this.finalizadoEm = finalizadoEm;
        this.idOrigem = idOrigem;
        this.idDestino = idDestino;
        NomeOrigem = nomeOrigem;
        NomeDestino = nomeDestino;
        this.dias = dias;
        this.servicoEquipamento = servicoEquipamento;
    }

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

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public ArrayList<ServicoEquipamento> getServicoEquipamento() {
        return servicoEquipamento;
    }

    public void setServicoEquipamento(ArrayList<ServicoEquipamento> servicoEquipamento) {
        this.servicoEquipamento = servicoEquipamento;
    }

    public String getAgendadaParaString()
    {
        return agendadaPara.toString("HH:mm");
    }

    public String getIniciadoEmString()
    {
        return iniciadoEm.toString("dd/mm/yyyy");
    }

    public DateTime getAgendadaPara()
    {
        return agendadaPara;
    }

    public void setAgendadaPara(DateTime agendadaPara)
    {
        this.agendadaPara = agendadaPara;
    }

    public DateTime getIniciadoEm()
    {
        return iniciadoEm;
    }

    public void setIniciadoEm(DateTime iniciadoEm)
    {
        this.iniciadoEm = iniciadoEm;
    }

    public DateTime getFinalizadoEm()
    {
        return finalizadoEm;
    }

    public void setFinalizadoEm(DateTime finalizadoEm)
    {
        this.finalizadoEm = finalizadoEm;
    }

    public String getFinalizadoEmString()
    {
        return finalizadoEm.toString("dd/mm/yyyy");
    }

}
