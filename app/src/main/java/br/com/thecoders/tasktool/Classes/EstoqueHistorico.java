package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

public class EstoqueHistorico
{
    @SerializedName("id")
    private int id;
    @SerializedName("quantity")
    private int quantidade;
    @SerializedName("type")
    private char tipo;
    @SerializedName("userId")
    private int usuarioID;
    @SerializedName("userName")
    private String usuario;
    @SerializedName("materialId")
    private int materialId;
    @SerializedName("materialName")
    private String material;
    @SerializedName("taskId")
    private int servicoId;
    @SerializedName("taskName")
    private String servico;
    @SerializedName("date")
    private DateTime data;

    public EstoqueHistorico(int id, int quantidade, char tipo, int usuarioID, String usuario, int materialId, String material, int servicoId, String servico, DateTime data)
    {
        this.id = id;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.usuarioID = usuarioID;
        this.usuario = usuario;
        this.materialId = materialId;
        this.material = material;
        this.servicoId = servicoId;
        this.servico = servico;
        this.data = data;
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

    public int getUsuarioID()
    {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID)
    {
        this.usuarioID = usuarioID;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public int getMaterialId()
    {
        return materialId;
    }

    public void setMaterialId(int materialId)
    {
        this.materialId = materialId;
    }

    public String getMaterial()
    {
        return material;
    }

    public void setMaterial(String material)
    {
        this.material = material;
    }

    public int getServicoId()
    {
        return servicoId;
    }

    public void setServicoId(int servicoId)
    {
        this.servicoId = servicoId;
    }

    public String getServico()
    {
        return servico;
    }

    public void setServico(String servico)
    {
        this.servico = servico;
    }

    public DateTime getData()
    {
        return data;
    }

    public void setData(DateTime data)
    {
        this.data = data;
    }
}
