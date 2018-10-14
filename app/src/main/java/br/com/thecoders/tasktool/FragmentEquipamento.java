package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.util.ArrayList;
import java.util.List;

import br.com.thecoders.tasktool.Classes.Equipamento;
import br.com.thecoders.tasktool.Classes.ServicoEquipamento;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentEquipamento extends Fragment
{
    private SharedPref sharedPref;
    private List<Equipamento> equipamentos;

    @BindView(R.id.equipamentos_spinner)
    public Spinner equipamentosSpinner;
    @BindView(R.id.saida_button)
    public ImageButton saidaButton;
    @BindView(R.id.entrada_button)
    public ImageButton entradaButton;
    @BindView(R.id.equipamentos_listview)
    public ListView equipamentosListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_equipamento, container, false);
        ButterKnife.bind(this, view);
        sharedPref = new SharedPref(getContext());
        listarEquipamentos();
        saidaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Ion.with(getContext())
                        .load("post", getResources().getString(R.string.url) + "task.equipament/")
                        .setHeader("Authorization", sharedPref.getToken())
                        .asJsonObject()
                        .withResponse()
                        .setCallback(new FutureCallback<Response<JsonObject>>()
                        {
                            @Override
                            public void onCompleted(Exception e, Response<JsonObject> result)
                            {
                                if (result.getHeaders().code() == 200)
                                {
                                    equipamentosSpinner.setSelection(0);
                                    Toast.makeText(getContext(), "Entrada de equipamento registrada", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getContext(), result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        saidaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Ion.with(getContext())
                        .load("delete", getResources().getString(R.string.url) + "task.equipament/")
                        .setHeader("Authorization", sharedPref.getToken())
                        .asJsonObject()
                        .withResponse()
                        .setCallback(new FutureCallback<Response<JsonObject>>()
                        {
                            @Override
                            public void onCompleted(Exception e, Response<JsonObject> result)
                            {
                                if (result.getHeaders().code() == 200)
                                {
                                    equipamentosSpinner.setSelection(0);
                                    Toast.makeText(getContext(), "Saída de equipamento registrada", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getContext(), result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        return view;
    }

    public void listarEquipamentos()
    {
        Ion.with(getContext())
                .load(getResources().getString(R.string.url) + "equipament.all/")
                .setHeader("Authorization", sharedPref.getToken())
                .asJsonObject()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonObject>>()
                {
                    @Override
                    public void onCompleted(Exception e, Response<JsonObject> result)
                    {
                        if (result.getHeaders().code() == 200)
                        {
                            equipamentos = new Gson().fromJson(result.getResult(), new TypeToken<ArrayList<Equipamento>>()
                            {
                            }.getType());
                            ArrayAdapter<Equipamento> dataAdapter = new ArrayAdapter<Equipamento>(getContext(),
                                    android.R.layout.simple_spinner_item, equipamentos);
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            equipamentosSpinner.setAdapter(dataAdapter);
                        }
                        else
                        {
                            Toast.makeText(getContext(), result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
