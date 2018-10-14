package br.com.thecoders.tasktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import br.com.thecoders.tasktool.Adapter.PagerAdapterServico;
import br.com.thecoders.tasktool.Classes.RespostaLogin;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Servico extends AppCompatActivity
{
    @BindView(R.id.supervisor_edittext)
    public EditText supervisorEditText;
    @BindView(R.id.servico_edittext)
    public EditText servicoEditText;
    @BindView(R.id.inicio_edittext)
    public EditText inicioEditText;
    @BindView(R.id.final_edittext)
    public EditText finalvisorEditText;
    @BindView(R.id.tab_layout)
    public TabLayout tabLayout;
    @BindView(R.id.viewpager)
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);

        ButterKnife.bind(this);

        supervisorEditText.setKeyListener(null);
        servicoEditText.setKeyListener(null);
        inicioEditText.setKeyListener(null);
        finalvisorEditText.setKeyListener(null);

        viewPager.setAdapter(new PagerAdapterServico(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        carregarDados();
    }

    public void iniciar(View v)
    {
    }

    public void movimentarAvaliar(View v)
    {
        startActivity(new Intent(this, MovimentoEstoque.class));
    }

    public void finalizar(View v)
    {
    }

    public void carregarDados()
    {
        Ion.with(this)
                .load("http://192.168.0.88/TaskTop/api/task.key/1")
                .asJsonObject()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonObject>>()
                {
                    @Override
                    public void onCompleted(Exception e, Response<JsonObject> result)
                    {
                        if (result.getHeaders().code() == 200)
                        {
                            RespostaLogin login = gson.fromJson(result.getResult(), RespostaLogin.class);
                            sharedPref.setLogin(loginEditText.getText().toString());
                            sharedPref.setSenha(salvarSenhaSwitch.isChecked() ? senhaEditText.getText().toString() : "");
                            sharedPref.setId(login.getUsuario().getId());
                            sharedPref.salvar();

                            loadingProgressBar.setVisibility(View.INVISIBLE);

                            if (login.getUsuario().getTipo().equals("funcionario"))
                                startActivity(new Intent(Login.this, Agenda.class));
                            else if (login.getUsuario().getTipo().equals("estoque"))
                                startActivity(new Intent(Login.this, Estoque.class));
                            else if (login.getUsuario().getTipo().equals("supervisor"))
                                startActivity(new Intent(Login.this, OrdemDeServico.class));
                        }
                        else
                        {
                            Toast.makeText(Login.this, result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}