package com.hh.waylightclient.Adapter;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hh.waylightclient.Bean.EventEntity;
import com.hh.waylightclient.Bean.MessageObjectEntity;
import com.hh.waylightclient.R;

import java.util.List;

/**
 * Created by thinkpad on 2019/4/17.
 * 事件显示界面（Recycler view）的adpater
 * modified on 2019/9/15
 *
 */

public class EventSearchAdapter extends RecyclerView.Adapter<EventSearchAdapter.ViewHolder>{
    private List<EventEntity> eventList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView eventTypeImage;
        TextView time;
        TextView content;//包含地点

        public ViewHolder(View view){
            super(view);
            eventTypeImage= (ImageView) view.findViewById(R.id.img_eventType);
            time=(TextView) view.findViewById(R.id.timePeriod);
            content=(TextView)view.findViewById(R.id.content);
        }
    }

    public EventSearchAdapter(List<EventEntity> eventList){
        this.eventList= eventList;
    }
    @Override
    public EventSearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent,false);
        EventSearchAdapter.ViewHolder holder=new EventSearchAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(EventSearchAdapter.ViewHolder holder, int position){
        EventEntity event=eventList.get(position);
        holder.eventTypeImage.setImageResource(event.getType());
        holder.time.setText(event.getTime());
        holder.content.setText(event.getContent());
    }

    @Override
    public int getItemCount(){
        return eventList.size();
    }
}
