package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.util.ArrayList;
import java.util.List;

import br.com.thecoders.tasktool.Classes.Material;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentMaterial extends Fragment
{
    private SharedPref sharedPref;
    private List<Material> materiais;

    @BindView(R.id.material_spinner)
    public Spinner materialSpinner;
    @BindView(R.id.quantidade_edittext)
    public EditText quantidadeEditText;
    @BindView(R.id.saida_button)
    public ImageButton saidaButton;
    @BindView(R.id.entrada_button)
    public ImageButton entradaButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_material, container, false);
        ButterKnife.bind(this, view);
        sharedPref = new SharedPref(getContext());
        listarMateriais();
        entradaButton.setOnClickListener(new View.OnClickListener()
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
                                    materialSpinner.setSelection(0);
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
                                    materialSpinner.setSelection(0);
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

    public void listarMateriais()
    {
        Ion.with(getContext())
                .load(getResources().getString(R.string.url) + "material.all/")
                .setHeader("Authorization", sharedPref.getToken())
                .setJsonObjectBody(new JsonObject())
                .asJsonObject()
                .withResponse()
                .setCallback(new FutureCallback<Response<JsonObject>>()
                {
                    @Override
                    public void onCompleted(Exception e, Response<JsonObject> result)
                    {
                        if (result.getHeaders().code() == 200)
                        {
                            materiais = new Gson().fromJson(result.getResult().get("items").getAsJsonArray(), new TypeToken<ArrayList<Material>>()
                            {
                            }.getType());
                            ArrayAdapter<Material> dataAdapter = new ArrayAdapter<>(getContext(),
                                    android.R.layout.simple_spinner_item, materiais);
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            materialSpinner.setAdapter(dataAdapter);
                        }
                        else
                        {
                            Toast.makeText(getContext(), result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
