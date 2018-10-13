package br.com.thecoders.tasktool.Classes;

import org.joda.time.DateTime;

public class EstoqueHistorico
{

    private int id;
    private int quantidade;
    private char tipo;
    private DateTime registradoEm;
    private Usuario responsavel;
    private Material material;
    private Servico servico;

    public EstoqueHistorico(int id, int quantidade, char tipo, DateTime registradoEm, Usuario responsavel, Material material, Servico servico)
    {
        this.id = id;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.registradoEm = registradoEm;
        this.responsavel = responsavel;
        this.material = material;
        this.servico = servico;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public char getTipo()
    {
        return tipo;
    }

    public void setTipo(char tipo)
    {
        this.tipo = tipo;
    }

    public DateTime getRegistradoEm()
    {
        return registradoEm;
    }

    public String getRegistradoEmString()
    {
        return registradoEm.toString("dd/MM/yyyy\nHH:mm");
    }

    public void setRegistradoEm(DateTime registradoEm)
    {
        this.registradoEm = registradoEm;
    }

    public Usuario getResponsavel()
    {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel)
    {
        this.responsavel = responsavel;
    }

    public Material getMaterial()
    {
        return material;
    }

    public void setMaterial(Material material)
    {
        this.material = material;
    }

    public Servico getServico()
    {
        return servico;
    }

    public void setServico(Servico servico)
    {
        this.servico = servico;
    }
}
