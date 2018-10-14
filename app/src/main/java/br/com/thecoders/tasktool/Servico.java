package br.com.thecoders.tasktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.joda.time.DateTime;

import br.com.thecoders.tasktool.Adapter.PagerAdapterServico;
import br.com.thecoders.tasktool.Util.DeserializerData;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Servico extends AppCompatActivity
{
    private SharedPref sharedPref;
    private int id;

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
        sharedPref = new SharedPref(this);
        id = getIntent().getIntExtra("Id", 0);

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
        id = 1;
        Ion.with(this)
                .load(getResources().getString(R.string.url) + "task.key/" + id)
                .setHeader("Authorization", sharedPref.getToken())
                .asJsonObject()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonObject>>()
                {
                    @Override
                    public void onCompleted(Exception e, Response<JsonObject> result)
                    {
                        if (result.getHeaders().code() == 200)
                        {
                            Gson gson = new GsonBuilder().registerTypeAdapter(DateTime.class, new DeserializerData()).create();
                            br.com.thecoders.tasktool.Classes.Servico servico = gson.fromJson(result.getResult(), br.com.thecoders.tasktool.Classes.Servico.class);
                            supervisorEditText.setText(servico.getSupervisor());
                            servicoEditText.setText(servico.getDescricao());
                            inicioEditText.setText(servico.getIniciadoEm().toString("dd/MM/yyyy HH:mm"));
                            inicioEditText.setText(servico.getFinalizadoEm().toString("dd/MM/yyyy HH:mm"));
                        }
                        else
                        {
                            Toast.makeText(Servico.this, result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}