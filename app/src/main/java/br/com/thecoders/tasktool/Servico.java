package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Servico extends AppCompatActivity
{
    @BindView(R.id.supervisor_edittext)
    public EditText supervisorEditText;
    @BindView(R.id.servico_edittext)
    public EditText servicorEditText;
    @BindView(R.id.inicio_edittext)
    public EditText inicioEditText;
    @BindView(R.id.final_edittext)
    public EditText finalvisorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);

        ButterKnife.bind(this);
    }

    public void iniciar(View v)
    {
    }

    public void movimentarEstoque(View v)
    {
    }

    public void finalizar(View v)
    {
    }
}