package com.hh.waylightclient.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hh.waylightclient.Adapter.EventSearchAdapter;
import com.hh.waylightclient.Adapter.MessageAdapter;
import com.hh.waylightclient.Bean.EventEntity;
import com.hh.waylightclient.Bean.MessageObjectEntity;
import com.hh.waylightclient.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thinkpad on 2019/4/17
 * modified in 2019/9/16
 */

public class EventSearchFragment extends Fragment {
    private Context mContext;
    private List<EventEntity> eventList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_eventsearch, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.events_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.mContext);
        recyclerView.setLayoutManager(layoutManager);
        EventSearchAdapter eventSearchAdapter = new EventSearchAdapter(eventList);
        recyclerView.setAdapter(eventSearchAdapter);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public void initData() {

        EventEntity event = new EventEntity("17:00-18:00  9/16","珞珈山综合超市中通快递","快递代取",R.drawable.pickupicon);
        eventList.add(event);

        event = new EventEntity("14:30  9/17","测绘学院227学术报告厅","混合整数线性模型",R.drawable.eventicon);
        eventList.add(event);

        event = new EventEntity("09:00-12:30  9/17","信息学部就业中心第二报告厅","中国电信集团*广州汇智通信技术有限公司",R.drawable.enrollmenticon);
        eventList.add(event);

        event = new EventEntity("09:00-12:30  9/17","信息学部就业中心第一报告厅","合肥杰发科技有限公司",R.drawable.enrollmenticon);
        eventList.add(event);

        event = new EventEntity("09:30-11:00  9/17","信息学部就业中心第三报告厅","烟台睿创微纳技术股份有限公司",R.drawable.enrollmenticon);
        eventList.add(event);

        event = new EventEntity("14:00-17:30  9/17","信息学部就业中心第二报告厅","成都索贝数码科技股份有限公司",R.drawable.enrollmenticon);
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
