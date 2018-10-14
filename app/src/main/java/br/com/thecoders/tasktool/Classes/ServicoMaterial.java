package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

public class ServicoMaterial
{
    @SerializedName("userId")
    private int usuarioId;
    @SerializedName("materialId")
    private int materialId;
    @SerializedName("quantity")
    private int quantidade;

    public ServicoMaterial(int usuarioId, int materialId, int quantidade)
    {
        this.usuarioId = usuarioId;
        this.materialId = materialId;
        this.quantidade = quantidade;
    }

    public int getUsuarioId()
    {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId)
    {
        this.usuarioId = usuarioId;
    }

    public int getMaterialId()
    {
        return materialId;
    }

    public void setMaterialId(int materialId)
    {
        this.materialId = materialId;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }
}
