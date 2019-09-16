package com.hh.waylightclient.Bean;

/**
 * Created by thinkpad on 2019/9/16.
 */

public class MessageObjectEntity {
    private String message;
    private int imageID;
    private String userName;

    public MessageObjectEntity(String message, int imageID, String userName){
        this.imageID=imageID;
        this.message=message;
        this.userName=userName;

    }

    public String getMessage(){
        return message;
    }
    public String getUserName(){
        return userName;
    }

    public int getImageID(){
        return imageID;
    }
}
