package com.hh.waylightclient.Adapter;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hh.waylightclient.Bean.MessageObjectEntity;
import com.hh.waylightclient.R;

import java.util.List;

/**
 * Created by thinkpad on 2019/9/16.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<MessageObjectEntity> messageObjectList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView headImage;
        TextView message;
        TextView userName;


        public ViewHolder(View view){
            super(view);
            headImage= (ImageView) view.findViewById(R.id.head_image);
            message=(TextView) view.findViewById(R.id.message);
            userName=(TextView)view.findViewById(R.id.user_name);

        }
    }

    public MessageAdapter(List<MessageObjectEntity> messageObjectList){
        this.messageObjectList=messageObjectList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_messageobject,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        MessageObjectEntity messageObject=messageObjectList.get(position);
        holder.headImage.setImageResource(messageObject.getImageID());
        holder.message.setText(messageObject.getMessage());
        holder.userName.setText(messageObject.getUserName());
    }

    @Override
    public int getItemCount(){
        return messageObjectList.size();
    }


}