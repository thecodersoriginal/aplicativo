package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

public class Material
{
    @SerializedName("id")
    private int id;
    @SerializedName("description")
    private String descricao;
    @SerializedName("actualQuantity")
    private int quantidadeAtual;

    public Material(int id, String descricao, int quantidadeAtual)
    {
        this.id = id;
        this.descricao = descricao;
        this.quantidadeAtual = quantidadeAtual;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public int getQuantidadeAtual()
    {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual)
    {
        this.quantidadeAtual = quantidadeAtual;
    }

    @Override
    public String toString()
    {
        return descricao;
    }
}
