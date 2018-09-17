package com.mike.menu.alarm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.mike.commonlib.logger.Log;
import com.mike.commonlib.logger.LogTool;
import com.mike.commonlib.utils.ToastUtil;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Date;

/**
 * 项目名称: Menu
 * 类描述:AlarmBuyService
 * 作者: Mike
 * 创建时间: 2018/8/29 17:38
 * 邮箱:2468139903@qq.com
 */
public class AlarmBuyService extends Service {


    public int anHour; //记录间隔时间

    public int number = 0; //记录alertdialog出现次数

    private MediaPlayer mediaPlayer = new MediaPlayer();

    Log log = Log.Factory.getInstance().setTag(getClass().getSimpleName());

    AlarmManager manager;
    PendingIntent pi;

    private class MyHandler extends Handler {
        private WeakReference<AlarmBuyService> weakReference;

        public MyHandler(AlarmBuyService alarmBuyService) {
            this.weakReference = new WeakReference<>(alarmBuyService);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (!mediaPlayer.isPlaying()){
                mediaPlayer.start();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(AlarmBuyService.this);
            builder.setTitle("提醒");
            builder.setMessage("该买菜了" + (number-1));
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mediaPlayer.reset();
                    initMediaPlayer();
                }
            });
            final AlertDialog dialog = builder.create();
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG);
            dialog.show();
        }
    }

    MyHandler myHandler = new MyHandler(this);

    private void initMediaPlayer() {
        File file = new File("/storage/emulated/0/menu", "2018年8月25日 21_43_17.mp3");
        try {
            mediaPlayer.setDataSource(file.getPath());
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (number != 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    log.d("executed at " + new Date().toString());
                   myHandler.sendEmptyMessage(1);
                }
            }).start();
        }
        manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int time = intent.getIntExtra("Time", 1);
        anHour = time * 60 * 1000;
        log.d("Time:" + time + "anhour:" + anHour);
        long triggerAtTime = SystemClock.elapsedRealtime() + (anHour);
        Intent i = new Intent(this, AlarmReceiver.class);
        pi = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        number++;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        manager.cancel(pi);
    }
}
