package br.com.thecoders.tasktool.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.thecoders.tasktool.FragmentEquipamento;
import br.com.thecoders.tasktool.FragmentMaterial;

public class PagerAdapter extends FragmentStatePagerAdapter
{
    int numTabs;

    public PagerAdapter(FragmentManager fragmentManager, int numTabs)
    {
        super(fragmentManager);
        this.numTabs = numTabs;
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
        return numTabs;
    }
}