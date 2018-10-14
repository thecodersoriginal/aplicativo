package br.com.thecoders.tasktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.joda.time.DateTime;

import br.com.thecoders.tasktool.Classes.Servico;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ServicoFuncionario extends AppCompatActivity
{
    private SharedPref sharedPref;
    private Servico servico;

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.supervisor_edittext)
    public EditText supervisorEditText;
    @BindView(R.id.servico_edittext)
    public EditText servicoEditText;
    @BindView(R.id.inicio_edittext)
    public EditText inicioEditText;
    @BindView(R.id.final_edittext)
    public EditText finalEditText;
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
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPref = new SharedPref(this);
        servico = (Servico) getIntent().getSerializableExtra("Servico");

        supervisorEditText.setText(servico.getSupervisor());
        servicoEditText.setText(servico.getDescricao());
        inicioEditText.setText(servico.getIniciadoEm() != null ? servico.getIniciadoEm().toString("dd/MM/yyyy HH:dd") : "Não iniciada");
        finalEditText.setText(servico.getFinalizadoEm() != null ? servico.getIniciadoEm().toString("dd/MM/yyyy HH:dd") : "Não finalizado");
        supervisorEditText.setKeyListener(null);
        servicoEditText.setKeyListener(null);
        inicioEditText.setKeyListener(null);
        finalEditText.setKeyListener(null);

        //viewPager.setAdapter(new PagerAdapterServico(getSupportFragmentManager()));
        //tabLayout.setupWithViewPager(viewPager);
    }

    public void iniciar(View v)
    {
        if (servico.getIniciadoEm() == null)
        {
            Ion.with(this)
                    .load(getResources().getString(R.string.url) + "task.start/" + servico.getId())
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
                                servico.setIniciadoEm(DateTime.now());
                                inicioEditText.setText(servico.getIniciadoEm() != null ? servico.getIniciadoEm().toString("dd/MM/yyyy HH:dd") : "Não iniciada");
                                Toast.makeText(ServicoFuncionario.this, "Serviço iniciado", Toast.LENGTH_SHORT).show();
                            }
                            else
                                Toast.makeText(ServicoFuncionario.this, result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else
            Toast.makeText(ServicoFuncionario.this, "A atividade já foi iniciada", Toast.LENGTH_SHORT).show();
    }

    public void movimentarAvaliar(View v)
    {
        if (servico.getIniciadoEm() != null && servico.getFinalizadoEm() == null)
            startActivity(new Intent(this, MovimentoEstoque.class));
        else
            Toast.makeText(ServicoFuncionario.this, "Só é possivel movimentar estoque para serviços em execução", Toast.LENGTH_SHORT).show();
    }

    public void finalizar(View v)
    {
        if (servico.getFinalizadoEm() == null)
        {
            Ion.with(this)
                    .load(getResources().getString(R.string.url) + "task.finish/" + servico.getId())
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
                                servico.setFinalizadoEm(DateTime.now());
                                finalEditText.setText(servico.getFinalizadoEm() != null ? servico.getIniciadoEm().toString("dd/MM/yyyy HH:dd") : "Não finalizado");
                                Toast.makeText(ServicoFuncionario.this, "Serviço finalizado", Toast.LENGTH_SHORT).show();
                            }
                            else
                                Toast.makeText(ServicoFuncionario.this, result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else
            Toast.makeText(ServicoFuncionario.this, "A atividade já foi finalizada", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}