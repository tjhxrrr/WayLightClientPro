package com.hh.waylightclient.Bean;

/**
 * Created by thinkpad on 2019/4/17.
 */

public class EventEntity {
    private int type;
    private String time;
    private String content;//包含location

    public EventEntity(String time, String content,int type){
        this.time=time;;
        this.content=content;
        this.type=type;
    }

    public int getType(){
        return type;
    }
    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

}
