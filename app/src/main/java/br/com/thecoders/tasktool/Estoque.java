package br.com.thecoders.tasktool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import br.com.thecoders.tasktool.Adapter.PagerAdapterServico;
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
    }

    public void movimentarEstoque(View v)
    {
        startActivity(new Intent(this, MovimentoEstoque.class));
    }
}