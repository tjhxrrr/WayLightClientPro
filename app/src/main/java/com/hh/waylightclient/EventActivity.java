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
        EventEntity event = new EventEntity("14:30  9/17","测绘学院227学术报告厅","混合整数线性模型",R.drawable.eventicon);
        eventList.add(event);

        event = new EventEntity("09:30  9/17","计算机学院B404会议室","Studies on UGC Mining Toward Sightseeing 2.0",R.drawable.eventicon);
        eventList.add(event);

        event = new EventEntity("10:30  9/17","计算机学院B404会议室","From Location Privacy to Spatiotemporal Event Privacy",R.drawable.eventicon);
        eventList.add(event);

        event = new EventEntity("19:00-21:00  9/17","文理学部教三102教室","在大学打造最强大脑,发现天赋事业",R.drawable.eventicon);
        eventList.add(event);

        event = new EventEntity("9:00-11:00  9/17","外语学院3008会议室","法国口述文学系列讲座",R.drawable.eventicon);
        eventList.add(event);

        event = new EventEntity("9:00-11:00  9/18","外语学院3008会议室","法国口述文学系列讲座",R.drawable.eventicon);
        eventList.add(event);

        event = new EventEntity("10:00-11:30  9/18","经济与管理学院A208","Optimal Dynamic Inspection （最优动态监察机制）",R.drawable.eventicon);
        eventList.add(event);

        event = new EventEntity("10:00-12:00  9/19","物理学院新楼4楼阳光房","球状星团的X射线研究",R.drawable.eventicon);
        eventList.add(event);

    }
}
