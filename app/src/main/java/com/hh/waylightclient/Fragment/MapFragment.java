package com.hh.waylightclient.Fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hh.waylightclient.EventActivity;
import com.hh.waylightclient.R;

/**
 * Created by thinkpad on 2019/4/17.
 */

public class MapFragment extends BaseFragmentForHome{
    private ImageView imageView;
    private Context mContext;
    private static final String TAG =MapFragment.class.getSimpleName();//得到“CommonFrameFragment”

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG,"框架Fragment页面被初始化了...");
        View view= inflater.inflate(R.layout.fragment_map, container, false);
        imageView=(ImageView) view.findViewById(R.id.img_map);
        imageView.setOnClickListener(new View.OnClickListener(){
            int tag=0;
            @Override
            public void onClick(View v) {
                if(tag==0){
                    imageView.setActivated(true);
                    tag=1;
                }else{
                    imageView.setActivated(false);
                    tag=0;
                }

            }
        });
        return view;

    }

    @Override
    protected void initData() {
        super.initData();
    }
}
