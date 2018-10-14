package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import java.util.ArrayList;
import java.util.List;

import br.com.thecoders.tasktool.Adapter.AdapterMaterialUtilizado;
import br.com.thecoders.tasktool.Classes.EstoqueHistorico;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentListaMaterial extends Fragment
{
    private SharedPref sharedPref;

    @BindView(R.id.lista_listview)
    public ListView listaListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.adapter_materialutilizado, container, false);
        ButterKnife.bind(this, view);
        sharedPref = new SharedPref(getContext());
        listarHistoricoStatus();
        return view;
    }

    public void listarHistoricoStatus()
    {
        Ion.with(getContext())
                .load(getResources().getString(R.string.url) + "stock.all/")
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
                            List<EstoqueHistorico> estoque = new Gson().fromJson(result.getResult().get("items").getAsJsonArray(), new TypeToken<ArrayList<EstoqueHistorico>>()
                            {
                            }.getType());
                            listaListView.setAdapter(new AdapterMaterialUtilizado(getContext(), estoque));
                        }
                        else
                        {
                            Toast.makeText(getContext(), result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
