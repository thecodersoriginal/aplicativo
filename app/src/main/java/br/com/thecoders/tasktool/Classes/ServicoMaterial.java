package br.com.thecoders.tasktool.Classes;

public class ServicoMaterial
{

    private Servico servico;
    private Material material;
    private int quantidade;

    public ServicoMaterial(Servico servico, Material material, int quantidade)
    {
        this.servico = servico;
        this.material = material;
        this.quantidade = quantidade;
    }

    public Servico getServico()
    {
        return servico;
    }

    public void setServico(Servico servico)
    {
        this.servico = servico;
    }

    public Material getMaterial()
    {
        return material;
    }

    public void setMaterial(Material material)
    {
        this.material = material;
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
