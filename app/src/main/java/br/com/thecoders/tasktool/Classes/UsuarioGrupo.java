package br.com.thecoders.tasktool.Classes;

public class UsuarioGrupo
{

    private Usuario usuario;
    private Grupo grupo;

    public UsuarioGrupo(Usuario usuario, Grupo grupo)
    {
        this.usuario = usuario;
        this.grupo = grupo;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }

    public Grupo getGrupo()
    {
        return grupo;
    }

    public void setGrupo(Grupo grupo)
    {
        this.grupo = grupo;
    }
}
