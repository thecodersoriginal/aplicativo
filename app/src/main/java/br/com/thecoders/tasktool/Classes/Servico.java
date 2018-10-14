package br.com.thecoders.tasktool.Classes;

import com.google.gson.annotations.SerializedName;

import org.joda.time.DateTime;

import java.io.Serializable;

public class Servico implements Serializable
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
    @SerializedName("interruptedIn")
    private DateTime interrompidoEm;
    @SerializedName("senderId")
    private int idSupervisor;
    @SerializedName("senderName")
    private String supervisor;
    @SerializedName("receiverId")
    private int IdFuncionario;
    @SerializedName("receiverName")
    private String Funcionario;
    @SerializedName("repeatInDays")
    private int repeatInDays;

    public Servico(int id, String descricao, DateTime agendadaPara, DateTime iniciadoEm, DateTime finalizadoEm, DateTime interrompidoEm, int idSupervisor, String supervisor, int idFuncionario, String funcionario, int repeatInDays)
    {
        this.id = id;
        this.descricao = descricao;
        this.agendadaPara = agendadaPara;
        this.iniciadoEm = iniciadoEm;
        this.finalizadoEm = finalizadoEm;
        this.interrompidoEm = interrompidoEm;
        this.idSupervisor = idSupervisor;
        this.supervisor = supervisor;
        IdFuncionario = idFuncionario;
        Funcionario = funcionario;
        this.repeatInDays = repeatInDays;
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

    public DateTime getInterrompidoEm()
    {
        return interrompidoEm;
    }

    public void setInterrompidoEm(DateTime interrompidoEm)
    {
        this.interrompidoEm = interrompidoEm;
    }

    public int getIdSupervisor()
    {
        return idSupervisor;
    }

    public void setIdSupervisor(int idSupervisor)
    {
        this.idSupervisor = idSupervisor;
    }

    public String getSupervisor()
    {
        return supervisor;
    }

    public void setSupervisor(String supervisor)
    {
        this.supervisor = supervisor;
    }

    public int getIdFuncionario()
    {
        return IdFuncionario;
    }

    public void setIdFuncionario(int idFuncionario)
    {
        IdFuncionario = idFuncionario;
    }

    public String getFuncionario()
    {
        return Funcionario;
    }

    public void setFuncionario(String funcionario)
    {
        Funcionario = funcionario;
    }

    public int getRepeatInDays()
    {
        return repeatInDays;
    }

    public void setRepeatInDays(int repeatInDays)
    {
        this.repeatInDays = repeatInDays;
    }
}
