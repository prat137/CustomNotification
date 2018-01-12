package com.creativeee.customnotification;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder notification;
    private static final int uniqueid=45612;
    private NotificationHelper notificationHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b;
        b=(Button) findViewById(R.id.button);
        notificationHelper=new NotificationHelper(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendOnChannelOne("title","this is msg");
            }
        });
    }

    public void sendOnChannelOne(String title,String msg) {
        NotificationCompat.Builder nb=notificationHelper.getChanneloneNotification(title,msg);
        notificationHelper.getManager().notify(1,nb.build());
    }
}
