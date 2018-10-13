package br.com.thecoders.tasktool.Classes;

import org.joda.time.DateTime;

public class Servico
{
    public int id;
    public String descricao;
    public DateTime agendadaPara;
    public DateTime iniciadoEm;
    public DateTime finalizadoEm;
    public Usuario origem;
    public Usuario destino;
    public int dias;

}
