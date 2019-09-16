package com.hh.waylightclient;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hh.waylightclient.Adapter.RnLFmPagerAdapter;
import com.hh.waylightclient.R;
import com.hh.waylightclient.Fragment.RegisterFragment;

import java.util.ArrayList;
    public class EventActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RnLFmPagerAdapter pagerAdapter;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"SEARCH","EXPLORE","TRACKED"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        init();
    }
    private void init() {

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //todo
        //fragments.add(new LoginFragment());

        for(int i=0;i<titles.length;i++){
            fragments.add(new RegisterFragment());
            tabLayout.addTab(tabLayout.newTab());
        }

        tabLayout.setupWithViewPager(viewPager,false);
        pagerAdapter = new RnLFmPagerAdapter(fragments,getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        for(int i=0;i<titles.length;i++){
            tabLayout.getTabAt(i).setText(titles[i]);
        }
    }
}
