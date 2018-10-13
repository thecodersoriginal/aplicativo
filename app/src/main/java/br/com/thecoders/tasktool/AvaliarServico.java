package br.com.thecoders.tasktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import br.com.thecoders.tasktool.Adapter.PagerAdapterServico;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AvaliarServico extends AppCompatActivity
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
    @BindView(R.id.iniciar_button)
    public ImageButton iniciarButton;
    @BindView(R.id.movimentarestoque_button)
    public ImageButton movimentarEstoqueButton;
    @BindView(R.id.finalizar_button)
    public ImageButton finalizarButton;

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

        iniciarButton.setVisibility(View.GONE);
        finalizarButton.setVisibility(View.GONE);
        movimentarEstoqueButton.setBackground(getDrawable(R.drawable.background_alert));
        movimentarEstoqueButton.setImageDrawable(getDrawable(R.drawable.ic_star));
    }

    public void iniciar(View v)
    {
    }

    public void movimentarEstoque(View v)
    {
        startActivity(new Intent(this, MovimentoEstoque.class));
    }

    public void finalizar(View v)
    {
    }
}