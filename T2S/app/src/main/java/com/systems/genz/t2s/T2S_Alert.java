package com.systems.genz.t2s;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by alex on 9/26/16.
 * TODO - need to change from pop up to simple notification that goes away after short period of time
 * T2S Alert Service displays a pop up alert screen that tells user to
 * stretch their neck. The user then hits OK button to reset service.
 * Alert Service pop up is triggered by message from Main Activity. Need to change
 * so that the T2S Sensor service triggers the alarm.
 * TODO put the alarm code in T2S_Seensor in the T2S_Utils code.
 */


/**
 * This {@code IntentService} does the app's actual work.
 * {@code SampleAlarmReceiver} (a {@code WakefulBroadcastReceiver}) holds a
 * partial wake lock for this service while the service does its work. When the
 * service is finished, it calls {@code completeWakefulIntent()} to release the
 * wake lock.
 */
public class T2S_Alert extends WakefulBroadcastReceiver {


    @Override
    public void onReceive(final Context context, Intent intent) {
        //this will update the UI with message
        MainActivity inst = MainActivity.instance();
        // this shows up on app splash page. don't want in final app
        inst.setAlarmText("Time To Stretch--Joe!!!");

        // TODO This will sound alarm but doesn't quit. Need to put in support to stop alarm
        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to
        //raise alarm in loop continuously then use MediaPlayer and setLooping(true)
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();

        //this will send a notification message
        ComponentName comp = new ComponentName(context.getPackageName(),
                T2S_Utils.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
    }
}