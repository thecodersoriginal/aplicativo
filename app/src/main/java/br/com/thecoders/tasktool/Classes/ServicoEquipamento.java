package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

public class ServicoEquipamento
{
    @SerializedName("userId")
    private int usuarioId;
    @SerializedName("equipmentId")
    private int equipamentoId;


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
    }
}
