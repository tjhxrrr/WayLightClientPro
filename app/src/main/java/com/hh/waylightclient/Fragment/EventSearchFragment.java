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
        for(int i=0;i<8;i++){
            EventEntity event = new EventEntity("8:00-11:00","Serena",R.drawable.eventicon);
            eventList.add(event);
        }
    }


}
