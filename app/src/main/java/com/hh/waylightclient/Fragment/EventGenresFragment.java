package com.hh.waylightclient.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hh.waylightclient.EventActivity;
import com.hh.waylightclient.R;

/**
 * Created by thinkpad on 2019/9/17.
 */

public class EventGenresFragment extends BaseFragmentForHome {
    private TextView textView;
    RelativeLayout lecture;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_eventgenres, container, false);
        lecture=(RelativeLayout) view.findViewById(R.id.lecture);
        lecture.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EventActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();

    }
}
