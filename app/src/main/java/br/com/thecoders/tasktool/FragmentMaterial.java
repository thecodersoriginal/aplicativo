package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
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

import br.com.thecoders.tasktool.Classes.Material;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentMaterial extends Fragment
{
    private SharedPref sharedPref;
    private List<Material> materiais;

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
        sharedPref = new SharedPref(getContext());
        adicionarButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //validar
            }
        });
        listarMateriais();
        return view;
    }

    public void listarMateriais()
    {
        Ion.with(getContext())
                .load(getResources().getString(R.string.url) + "task.all/")
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
                            materiais = new Gson().fromJson(result.getResult(), new TypeToken<ArrayList<Material>>()
                            {
                            }.getType());
                        }
                        else
                        {
                            Toast.makeText(getContext(), result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}
