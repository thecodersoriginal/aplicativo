package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdemDeServico extends AppCompatActivity
{
    @BindView(R.id.descricao_edittext)
    public EditText descricaoEdittext;
    @BindView(R.id.funcionario_edittext)
    public EditText funcionarioEdittext;
    @BindView(R.id.data_edittext)
    public EditText dataEdittext;
    @BindView(R.id.hora_edittext)
    public EditText horaEdittext;
    @BindView(R.id.repeticao_edittext)
    public EditText repeticaoEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordemdeservico);

        ButterKnife.bind(this);

        dataEdittext.setKeyListener(null);
        horaEdittext.setKeyListener(null);
    }

    public void excluir(View v)
    {
    }

    public void confirmar(View v)
    {
    }

}