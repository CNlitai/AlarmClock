package com.example.dell.AlarmClock;
/**
 * @author created by 惠普
 * @package name com.example.dell.AlarmClock
 * @date created on 2020/6/9
 * @description
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dell.AlarmClock.ShakeHelper;

import java.io.IOException;

public class AlarmAlert extends Activity  {
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //int position = getIntent().getIntExtra("position",-1);
        mediaPlayer = MediaPlayer.create(this,R.raw.clockmusic2);
        mediaPlayer.start();
        new AlertDialog.Builder(AlarmAlert.this)
                .setIcon(R.drawable.clock)
                .setTitle("闹钟响了")
                .setCancelable(false)
                .setMessage("时间到了！")

                .setPositiveButton("关掉"
                        , new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                AlarmAlert.this.finish();
                                mediaPlayer.stop();
                            }
                        }).show();


        ShakeHelper shakeHelper = new ShakeHelper(AlarmAlert.this);

        //mediaPlayer.stop();

//        private void startAlarm() {
//        mediaPlayer = MediaPlayer.create(this, getSystemDefultRingtoneUri());
//        mediaPlayer.setLooping(true);
//        try {
//            mediaPlayer.prepare();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        mediaPlayer.start();
//    }
//
//        private void stopAlarm(){
//        mediaPlayer.stop();
//    }
//
//        /**
//         * 获取系统自带铃声的uri
//         * @return RingtoneManager.getActualDefaultRingtoneUri(this,
//                RingtoneManager.TYPE_RINGTONE)
//         */
//        private Uri getSystemDefultRingtoneUri() {
//        return RingtoneManager.getActualDefaultRingtoneUri(this,
//                RingtoneManager.TYPE_RINGTONE);
//    }
//    }




}
}
