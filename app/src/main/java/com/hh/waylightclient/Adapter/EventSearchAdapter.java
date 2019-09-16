package com.hh.waylightclient.Adapter;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

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

public class EventSearchAdapter extends RecyclerView.Adapter<EventSearchAdapter.ViewHolder> {
    private List<EventEntity> eventList;
    private Context mcontext;
    private PopupWindow popupWindow;
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView eventTypeImage;
        TextView time;
        TextView content;//包含地点
        Button dislike;
        Button add;


        public ViewHolder(Context context,View view){
            super(view);
            eventTypeImage= (ImageView) view.findViewById(R.id.img_eventType);
            time=(TextView) view.findViewById(R.id.timePeriod);
            content=(TextView)view.findViewById(R.id.content);
            dislike=(Button)view.findViewById(R.id.dislike);
            add=(Button)view.findViewById(R.id.add);
            mcontext=context;

        }
    }


    public EventSearchAdapter(List<EventEntity> eventList){
        this.eventList= eventList;
    }
    @Override
    public EventSearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent,false);
        EventSearchAdapter.ViewHolder holder=new EventSearchAdapter.ViewHolder(view.getContext(),view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final EventSearchAdapter.ViewHolder holder, int position){
        EventEntity event=eventList.get(position);
        holder.eventTypeImage.setImageResource(event.getType());
        holder.time.setText(event.getTime());
        holder.content.setText(event.getContent());
        holder.dislike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Toast.makeText(v.getContext(), "不喜欢此类通知", Toast.LENGTH_SHORT).show();
                holder.dislike.setActivated(true);
            }
        });
        holder.add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                LayoutInflater inflater=(LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View vPopupWindow = inflater.inflate(R.layout.popupwindow_eventinfo, null, false);//引入弹窗布局
                popupWindow = new PopupWindow(vPopupWindow, ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, true);
                //View parentView = LayoutInflater.from(mcontext).inflate(R.layout.popupwindow_eventinfo, null);
                //popupWindow.showAtLocation(v, Gravity.BOTTOM,0,0);
                popupWindow.showAsDropDown(holder.dislike,20,10);
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
                Button submit=(Button)vPopupWindow.findViewById(R.id.btn_submit);
                EditText time=(EditText) vPopupWindow.findViewById(R.id.time);
                EditText address=(EditText)vPopupWindow.findViewById(R.id.address);
                EditText discription=(EditText)vPopupWindow.findViewById(R.id.discription);
                time.setText("8:00-11:00");
                address.setText("武汉大学资源与环境科学学院");
                discription.setText("讲座");

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), "已添加到日程", Toast.LENGTH_SHORT).show();
                        popupWindow.dismiss();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount(){
        return eventList.size();
    }


}
