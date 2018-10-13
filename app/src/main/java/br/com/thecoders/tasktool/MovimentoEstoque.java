package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovimentoEstoque extends AppCompatActivity
{
    @BindView(R.id.usuario_edittext)
    public EditText usuarioEditText;
    @BindView(R.id.servico_edittext)
    public EditText servicoEditText;
    @BindView(R.id.equipamento_tab)
    public TabItem equipamentoTab;
    @BindView(R.id.material_tab)
    public TabItem materialTab;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento_estoque);

        ButterKnife.bind(this);
    }

    public void confirmar(View v)
    {
    }
}
