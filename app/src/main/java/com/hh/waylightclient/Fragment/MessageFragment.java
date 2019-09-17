package com.hh.waylightclient.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hh.waylightclient.Adapter.MessageAdapter;
import com.hh.waylightclient.Bean.MessageObjectEntity;
import com.hh.waylightclient.R;

import java.util.ArrayList;
import java.util.List;

import static com.hh.waylightclient.R2.id.container;
import static com.hh.waylightclient.R2.id.recycler_view;

/**
 * Created by thinkpad on 2019/9/16.
 */

public class MessageFragment extends BaseFragmentForHome {

    private List<MessageObjectEntity> messageObjectList = new ArrayList<>();
    private static final String TAG = MapFragment.class.getSimpleName();//得到“CommonFrameFragment”

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "框架Fragment页面被初始化了...");
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.mContext);
        recyclerView.setLayoutManager(layoutManager);
        MessageAdapter messageAdapter = new MessageAdapter(messageObjectList);
        recyclerView.setAdapter(messageAdapter);
        return view;

    }

    @Override
    protected void initData() {
        super.initData();
        MessageObjectEntity messageObject = new MessageObjectEntity("Hello!", R.drawable.headimage,"+7Ricky");
        messageObjectList.add(messageObject);

        messageObject = new MessageObjectEntity("已接", R.drawable.headimg,"丁家祺");
        messageObjectList.add(messageObject);

        messageObject = new MessageObjectEntity("好的，谢谢~", R.drawable.headimage2,"金蕾");
        messageObjectList.add(messageObject);

    }
}
