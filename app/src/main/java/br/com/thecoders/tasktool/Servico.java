package br.com.thecoders.tasktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import br.com.thecoders.tasktool.Adapter.PagerAdapterServico;
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
}