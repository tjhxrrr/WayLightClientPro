package com.hh.waylightclient;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hh.waylightclient.Adapter.EventSearchAdapter;
import com.hh.waylightclient.Adapter.RnLFmPagerAdapter;
import com.hh.waylightclient.Bean.EventEntity;
import com.hh.waylightclient.R;
import com.hh.waylightclient.Fragment.RegisterFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * !!!!!千万注意，event活动的布局与eventsearch相同
 * !!!!!activity_event.xml是eventfragment的布局
 */
public class EventActivity extends AppCompatActivity {
    private List<EventEntity> eventList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_eventsearch);//
        initData();
        init();
    }
    private void init() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.events_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        EventSearchAdapter eventSearchAdapter = new EventSearchAdapter(eventList);
        recyclerView.setAdapter(eventSearchAdapter);

    }
    public void initData() {
        for(int i=0;i<8;i++){
            EventEntity event = new EventEntity("8:00-11:00","Serena",R.drawable.eventicon);
            eventList.add(event);
        }
    }
}
