package br.com.thecoders.tasktool.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.thecoders.tasktool.FragmentListaEquipamento;
import br.com.thecoders.tasktool.FragmentListaMaterial;

public class PagerAdapterServico extends FragmentPagerAdapter
{

    public PagerAdapterServico(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new FragmentListaEquipamento();
            case 1:
                return new FragmentListaMaterial();
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return "Equipamento";
            case 1:
                return "Material";
            default:
                return null;
        }
    }
}
