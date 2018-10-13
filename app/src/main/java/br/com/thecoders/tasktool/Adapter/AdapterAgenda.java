package br.com.thecoders.tasktool.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import br.com.thecoders.tasktool.Classes.Servico;
import br.com.thecoders.tasktool.R;

public class AdapterAgenda extends BaseAdapter
{
    private LayoutInflater layoutInflater;
    private List<Servico> servicos;

    public AdapterAgenda(Context context, List<Servico> servicos)
    {
        this.layoutInflater = LayoutInflater.from(context);
        this.servicos = servicos;
    }

    @Override
    public int getCount()
    {
        return servicos.size();
    }

    @Override
    public Object getItem(int i)
    {
        return servicos.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return servicos.get(i).getId();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup)
    {
        View view = convertView;
        if (view == null)
            view = layoutInflater.inflate(R.layout.adapter_agenda, null);

        TextView horaTextView = view.findViewById(R.id.hora_textview);
        TextView servicoTextView = view.findViewById(R.id.servico_textview);
        CheckBox realizadaCheckBox = view.findViewById(R.id.realizada_checkbox);

        Servico servico = servicos.get(i);
        horaTextView.setText(servico.getAgendadaParaString());
        servicoTextView.setText(servico.getDescricao());
        realizadaCheckBox.setChecked(servico.getFinalizadoEm() != null);

        return view;
    }
}
