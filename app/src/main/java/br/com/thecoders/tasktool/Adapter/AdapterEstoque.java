package br.com.thecoders.tasktool.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.thecoders.tasktool.Classes.EstoqueHistorico;
import br.com.thecoders.tasktool.R;

public class AdapterEstoque extends BaseAdapter
{
    private LayoutInflater layoutInflater;
    private List<EstoqueHistorico> estoque;

    public AdapterEstoque(Context context, List<EstoqueHistorico> estoque)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.estoque = estoque;
    }

    @Override
    public int getCount()
    {
        return estoque.size();
    }

    @Override
    public Object getItem(int i)
    {
        return estoque.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return estoque.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup)
    {
        View view = convertView;
        if (view == null)
            view = layoutInflater.inflate(R.layout.adapter_estoque, null);

        TextView dataTextView = view.findViewById(R.id.data_textview);
        TextView usuarioTextView = view.findViewById(R.id.usuario_textview);
        TextView quantidadeTextView = view.findViewById(R.id.quantidade_textview);
        TextView material = view.findViewById(R.id.material_textview);

        EstoqueHistorico registroEstoque = estoque.get(i);
        dataTextView.setText(registroEstoque.getData().toString("dd/MM/yyyy HH:mm"));
        usuarioTextView.setText(registroEstoque.getUsuario());
        quantidadeTextView.setText(registroEstoque.getTipo() == 'S' ? String.format("-%d", registroEstoque.getQuantidade()) : String.format("+%d", registroEstoque.getQuantidade()));
        material.setText(registroEstoque.getMaterial());

        return view;
    }
}
