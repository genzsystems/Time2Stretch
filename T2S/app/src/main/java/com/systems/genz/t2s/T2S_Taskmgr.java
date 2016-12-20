package com.systems.genz.t2s;

import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by alex on 9/26/16.
 * Taskmgr haneles following service requests:
 * - Sets the user's preferences
 * - Reads the user's preferences
 * - enable or disable application
 * - Timeout adjustments. Values in minutes
 * - future preference such as vibrate/ringer on or off
 * - Starting, Stopping and Restarting the application using
 * - callback functions. When the user moves to another app,
 * - this routine starts the alert timer and then moves to the
 * - background. When users open T2S app again, pause
 * - the timer. Restart when users switch to another app or
 * - exit this app.
 */

public class T2S_Taskmgr extends PreferenceActivity {

    /*T2S_Alert alert_svc = new T2S_Alert();
    T2S_Sensor sensor_svc = new T2S_Sensor();*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content,
                        new MainSettingsFragment()).commit();

    }

    // This call creates the options menu
    public static class MainSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

    // TODO need to call T2S_Sensor and get feedback of when phone is in 45 degrees
    // angle. Need a global counter to determine how long phone in certain position
    // then call T2S_Alert (which will call T2S_Utils) to send an alert to the user
    // to stretch their neck. Alert should go away after user hits alert message
    // on main screen
}


