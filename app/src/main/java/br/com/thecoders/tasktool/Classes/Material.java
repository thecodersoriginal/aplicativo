package br.com.thecoders.tasktool.Classes;

public class Material
{

    private int id;
    private String descricao;
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
}
