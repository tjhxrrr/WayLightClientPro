package com.hh.waylightclient;

import android.support.v7.app.AppCompatActivity;;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

/**
 * Created by thinkpad on 2019/3/21.
 */

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_DELAY_MILLIS = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
        new Handler().postDelayed(new Runnable() {
            public void run() {
                goHome();
            }
        }, SPLASH_DELAY_MILLIS);

    }
    private void goHome() {
        Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
        SplashActivity.this.startActivity(intent);
        SplashActivity.this.finish();
    }
}
