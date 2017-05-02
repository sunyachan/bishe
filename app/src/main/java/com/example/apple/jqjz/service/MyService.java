package com.example.apple.jqjz.service;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.activity.DBActivity;
import com.example.apple.jqjz.activity.SetActivity;

import java.util.List;

public class MyService extends Service {

    public Context context;
    public Boolean isBack;
    NotificationManager mNotificationManager;
    NotificationCompat.Builder mBuilder;


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context= SetActivity.content;
        Log.i("sun","开启服务");


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isBack=isAppIsInBackground(context);
//        if (isBack){
//            Log.i("sun","该App运行于后台");
//        }else {
//            Log.i("sun","该App运行于前台");
//        }


            putoutLog();


        return START_STICKY;
    }

    private void putoutLog() {
        while (!isBack) {

            new Thread(new Runnable() {
                @Override
                public void run() {
//                    判断App是否在后台运行
                    isBack=isAppIsInBackground(context);
                    if (isBack){
                        //显示通知栏信息
                        showMsg();
//                        Log.i("sun","该App运行于后台");
                    }else {
//                        Log.i("sun","该App运行于前台");
                    }
                }
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void showMsg() {
        mNotificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mBuilder=new NotificationCompat.Builder(context);
        Intent intent = new Intent(context, DBActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setAutoCancel(true)
                .setTicker("加氢精制数据异常")
                .setContentTitle("数据异常")
                .setContentText("加氢精制数据异常，点击查看详情")
                .setSmallIcon(R.drawable.ys)
                .setPriority(Notification.PRIORITY_MAX)
                .setContentIntent(pendingIntent);
        mNotificationManager.notify(1,mBuilder.build());


    }


    //    判断App是否在后台运行
    private Boolean isAppIsInBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                /*
                BACKGROUND=400 EMPTY=500 FOREGROUND=100
                GONE=1000 PERCEPTIBLE=130 SERVICE=300 ISIBLE=200
                 */
//                Log.i(context.getPackageName(), "此appimportace ="
//                        + appProcess.importance
//                        + ",context.getClass().getName()="
//                        + context.getClass().getName());
                if (appProcess.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
//                    Log.i(context.getPackageName(), "处于后台"
//                            + appProcess.processName);
                    return true;
                } else {
//                    Log.i(context.getPackageName(), "处于前台"
//                            + appProcess.processName);
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("sun","关闭服务");
    }
}
