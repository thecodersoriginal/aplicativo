package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentMaterial extends Fragment
{
    @BindView(R.id.material_edittext)
    public EditText materialEditText;
    @BindView(R.id.quantidade_edittext)
    public EditText quantidadeEditText;
    @BindView(R.id.adicionar_button)
    public ImageButton adicionarButton;
    @BindView(R.id.materiais_listview)
    public ListView materiaisListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_material, container, false);
        ButterKnife.bind(this, view);
        adicionarButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //validar
            }
        });
        return view;
    }

}
