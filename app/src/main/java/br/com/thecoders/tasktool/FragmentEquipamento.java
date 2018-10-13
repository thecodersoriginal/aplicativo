package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;

public class FragmentEquipamento extends Fragment
{
    @BindView(R.id.equipamento_edittext)
    public EditText equipamentoEditText;
    @BindView(R.id.adicionar_button)
    public Button adicionarButton;
    @BindView(R.id.equipamentos_listview)
    public Button equipamentosLIstView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_equipamento, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        adicionarButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //validar
            }
        });
    }
}
