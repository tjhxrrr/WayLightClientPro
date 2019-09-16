package com.hh.waylightclient.Adapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by thinkpad on 2019/4/17.
 * 目前，是EventActivity与RegisterActivity的Adapter
 */

public class RnLFmPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list_fragment;                         //fragment列表

    private List<String> list_Title;                              //tab名的列表

    public RnLFmPagerAdapter(List<Fragment>list_fragment,FragmentManager fm) {

        super(fm);

        this.list_fragment = list_fragment;


    }



    @Override

    public Fragment getItem(int i) {

        return list_fragment.get(i);

    }



    @Override

    public int getCount() {

        return list_fragment.size();

    }
}
