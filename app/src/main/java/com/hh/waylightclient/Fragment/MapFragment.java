package com.hh.waylightclient.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by thinkpad on 2019/4/17.
 */

public class MapFragment extends BaseFragmentForHome{
    private TextView textView;

    private static final String TAG =MapFragment.class.getSimpleName();//得到“CommonFrameFragment”

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG,"框架Fragment页面被初始化了...");
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        return textView;

    }

    @Override
    protected void initData() {
        super.initData();
        textView.setText("This is for test!");
    }
}
