package br.com.thecoders.tasktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import br.com.thecoders.tasktool.Adapter.PagerAdapterServico;
import br.com.thecoders.tasktool.Classes.EstoqueHistorico;
import br.com.thecoders.tasktool.Util.DeserializerData;
import br.com.thecoders.tasktool.Util.SharedPref;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Estoque extends AppCompatActivity
{
    private SharedPref sharedPref;

    @BindView(R.id.tab_layout)
    public TabLayout tabLayout;
    @BindView(R.id.viewpager)
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);

        ButterKnife.bind(this);
        sharedPref = new SharedPref(this);

        viewPager.setAdapter(new PagerAdapterServico(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        carregarDados();
    }

    public void movimentarEstoque(View v)
    {
        startActivity(new Intent(this, MovimentoEstoque.class));
    }
}