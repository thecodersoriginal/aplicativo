package br.com.thecoders.tasktool.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.thecoders.tasktool.FragmentEquipamento;
import br.com.thecoders.tasktool.FragmentMaterial;

public class PagerAdapterEstoque extends FragmentPagerAdapter
{

    public PagerAdapterEstoque(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new FragmentEquipamento();
            case 1:
                return new FragmentMaterial();
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
