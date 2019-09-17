package com.hh.waylightclient;

import android.app.Application;

import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;

/**
 * Created by thinkpad on 2019/3/23.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        QMUISwipeBackActivityManager.init(this);
        com.igexin.sdk.PushManager.getInstance().initialize(getApplicationContext(), com.hh.waylightclient.Service.PushService.class);
        com.igexin.sdk.PushManager.getInstance().registerPushIntentService(getApplicationContext(), com.hh.waylightclient.Service.IntentService.class);
    }
}
