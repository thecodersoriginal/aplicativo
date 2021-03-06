package br.com.thecoders.tasktool.Util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref
{
    private SharedPreferences sharedPref;

    private String login;
    private String senha;
    private String token;
    private String tipo;
    private int id;

    public SharedPref(Context context)
    {
        sharedPref = context.getSharedPreferences("Config", Context.MODE_PRIVATE);

        login = sharedPref.getString("Login", "");
        senha = sharedPref.getString("Senha", "");
        token = sharedPref.getString("Token", "");
        tipo = sharedPref.getString("Tipo", "");
        id = sharedPref.getInt("Id", 0);
    }

    public void salvar()
    {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Login", login);
        editor.putString("Senha", senha);
        editor.putString("Token", "Bearer " + token);
        editor.putString("Tipo", tipo);
        editor.putInt("Id", id);
        editor.apply();
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
}
