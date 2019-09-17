package com.hh.waylightclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PushInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_info);
        Button addEvent=(Button)findViewById(R.id.btn_addevent);
        addEvent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PushInfoActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }
}
