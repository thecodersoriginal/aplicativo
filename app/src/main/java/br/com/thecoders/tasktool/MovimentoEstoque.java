package br.com.thecoders.tasktool;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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

import br.com.thecoders.tasktool.Adapter.PagerAdapterEstoque;
import br.com.thecoders.tasktool.Classes.Servico;
import br.com.thecoders.tasktool.Classes.Usuario;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MovimentoEstoque extends AppCompatActivity
{
    private SharedPref sharedPref;
    private List<Usuario> usuarios;
    private Servico servico;

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.usuarios_spinner)
    public Spinner usuariosSpinner;
    @BindView(R.id.servico_edittext)
    public EditText servicoEditText;
    @BindView(R.id.tab_layout)
    public TabLayout tabLayout;
    @BindView(R.id.viewpager)
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movimento_estoque);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPref = new SharedPref(this);

        servicoEditText.setKeyListener(null);

        viewPager.setAdapter(new PagerAdapterEstoque(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        listarUsuarios();
    }

    public void listarUsuarios()
    {
        Ion.with(this)
                .load(getResources().getString(R.string.url) + "user.all/")
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
                            usuarios = new Gson().fromJson(result.getResult().get("items").getAsJsonArray(), new TypeToken<ArrayList<Usuario>>()
                            {
                            }.getType());
                            ArrayAdapter<Usuario> dataAdapter = new ArrayAdapter<Usuario>(MovimentoEstoque.this,
                                    android.R.layout.simple_spinner_item, usuarios);
                            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            usuariosSpinner.setAdapter(dataAdapter);
                        }
                        else
                        {
                            Toast.makeText(MovimentoEstoque.this, result.getResult().get("error").getAsJsonObject().get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
