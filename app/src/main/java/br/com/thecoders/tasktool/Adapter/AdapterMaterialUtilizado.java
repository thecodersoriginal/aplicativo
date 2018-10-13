package br.com.thecoders.tasktool.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.thecoders.tasktool.Classes.ServicoMaterial;
import br.com.thecoders.tasktool.R;

public class AdapterMaterialUtilizado extends BaseAdapter
{
    private LayoutInflater layoutInflater;
    private List<ServicoMaterial> materiais;

    public AdapterMaterialUtilizado(Context context, List<ServicoMaterial> materiais)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.materiais = materiais;
    }

    @Override
    public int getCount()
    {
        return materiais.size();
    }

    @Override
    public Object getItem(int i)
    {
        return materiais.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup)
    {
        View view = convertView;
        if (view == null)
            view = layoutInflater.inflate(R.layout.adapter_materialutilizado, null);

        TextView quantidadeTextView = view.findViewById(R.id.quantidade_textview);
        TextView materialTextView = view.findViewById(R.id.material_textview);

        ServicoMaterial material = materiais.get(i);

        quantidadeTextView.setText(String.valueOf(material.getQuantidade()));
        materialTextView.setText(material.getMaterial().getDescricao());

        return view;
    }
}