package br.com.thecoders.tasktool.Classes;

public class Equipamento
{
    private int id;
    private String codigo;
    private String descricao;
    private boolean emUso;
    private boolean ativo;

    public Equipamento(int id, String codigo, String descricao, boolean emUso, boolean ativo)
    {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.emUso = emUso;
        this.ativo = ativo;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCodigo()
    {
        return codigo;
    }

    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public boolean isEmUso()
    {
        return emUso;
    }

    public void setEmUso(boolean emUso)
    {
        this.emUso = emUso;
    }

    public boolean isAtivo()
    {
        return ativo;
    }

    public void setAtivo(boolean ativo)
    {
        this.ativo = ativo;
    }
}
