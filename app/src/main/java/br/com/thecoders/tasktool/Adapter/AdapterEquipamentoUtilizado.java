package br.com.thecoders.tasktool.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.thecoders.tasktool.Classes.ServicoEquipamento;
import br.com.thecoders.tasktool.R;

public class AdapterEquipamentoUtilizado extends BaseAdapter
{
    private LayoutInflater layoutInflater;
    private List<ServicoEquipamento> equipamentos;

    public AdapterEquipamentoUtilizado(Context context, List<ServicoEquipamento> equipamentos)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.equipamentos = equipamentos;
    }

    @Override
    public int getCount()
    {
        return equipamentos.size();
    }

    @Override
    public Object getItem(int i)
    {
        return equipamentos.get(i);
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
            view = layoutInflater.inflate(R.layout.adapter_equipamentoutilizado, null);

        TextView equipamentoTextView = view.findViewById(R.id.equipamento_textview);

        ServicoEquipamento equipamento = equipamentos.get(i);

        equipamentoTextView.setText(equipamento.getEquipamento().getDescricao());

        return view;
    }
}
