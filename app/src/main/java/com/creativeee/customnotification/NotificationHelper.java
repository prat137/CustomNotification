package com.creativeee.customnotification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Dell on 02-01-2018.
 */

public class NotificationHelper extends ContextWrapper {
    public static final String channelid="channel1id";
    public static final String channelName="channelname";
    private NotificationManager nmanager;

    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            createChannels();
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    public void createChannels()
    {
        NotificationChannel channel=new NotificationChannel(channelid,channelName, NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableLights(true);
        channel.enableVibration(true);
        channel.setLightColor(R.color.colorPrimary);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getManager().createNotificationChannel(channel);

    }
    public NotificationManager getManager() {
        if(nmanager==null){
            nmanager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return nmanager;
    }
    public NotificationCompat.Builder getChanneloneNotification(String title,String msg){
        return new NotificationCompat.Builder(getApplicationContext(),channelid)
                .setContentTitle("this is channel")
                .setContentText("this is message")
                .setSmallIcon(R.mipmap.ic_launcher);

    }
}
