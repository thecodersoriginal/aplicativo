package br.com.thecoders.tasktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity
{
    @BindView(R.id.login_edittext)
    public EditText loginEditText;
    @BindView(R.id.senha_edittext)
    public EditText senhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    public void entrar(View v)
    {
        //if (validar())
        startActivity(new Intent(this, AvaliarServico.class));
    }

    public boolean validar()
    {
        boolean ok = true;
        if (loginEditText.getText().toString().isEmpty())
        {
            loginEditText.setError("Login deve ser preenchido");
            ok = false;
        }
        else if (senhaEditText.getText().toString().isEmpty())
        {
            senhaEditText.setError("Senha deve ser preenchida");
            ok = false;
        }
        return ok;
    }
}
