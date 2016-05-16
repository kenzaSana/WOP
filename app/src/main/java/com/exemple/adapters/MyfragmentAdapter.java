package com.exemple.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by KenZack on 15/05/2016.
 */
public class MyfragmentAdapter extends FragmentPagerAdapter {
List<Fragment> listFragments;

    public MyfragmentAdapter(FragmentManager fm, List<Fragment> listFragments) {
        super(fm);
        this.listFragments=listFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }

    @Override
    public int getCount() {
        return listFragments.size();
    }
}
