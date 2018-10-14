package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

public class ServicoEquipamento
{
    @SerializedName("userId")
    private int usuarioId;
    @SerializedName("equipmentId")
    private int equipamentoId;

<<<<<<< HEAD

    public ServicoEquipamento(int usuarioId, int equipamentoId)
    {
        this.usuarioId = usuarioId;
        this.equipamentoId = equipamentoId;
    }

    public int getUsuarioId()
    {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId)
    {
        this.usuarioId = usuarioId;
    }

    public int getEquipamentoId()
    {
        return equipamentoId;
    }

    public void setEquipamentoId(int equipamentoId)
    {
        this.equipamentoId = equipamentoId;
=======
    private int id;
    private int nomeEquipamento;

    public ServicoEquipamento(int id, int nomeEquipamento) {
        this.id = id;
        this.nomeEquipamento = nomeEquipamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(int nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
>>>>>>> 5b30407b926e7231ca2557848c507cd4bb2e67c9
    }
}
