package com.hh.waylightclient.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hh.waylightclient.Adapter.RnLFmPagerAdapter;
import com.hh.waylightclient.R;

import java.util.ArrayList;

/**
 * Created by thinkpad on 2019/9/16.
 */

public class EventFragment extends BaseFragmentForHome {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RnLFmPagerAdapter pagerAdapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"SEARCH","EXPLORE","TRACKED"};

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_event, container, false);

        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        //todo:将来三个菜单不能完全一样
        for(int i=0;i<titles.length;i++){
            fragments.add(new EventSearchFragment());
            tabLayout.addTab(tabLayout.newTab());
        }

        tabLayout.setupWithViewPager(viewPager,false);
        pagerAdapter = new RnLFmPagerAdapter(fragments,getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        for(int i=0;i<titles.length;i++){
            tabLayout.getTabAt(i).setText(titles[i]);
        }

        return view;
    }


    @Override
    protected void initData() {
        super.initData();

    }
}
