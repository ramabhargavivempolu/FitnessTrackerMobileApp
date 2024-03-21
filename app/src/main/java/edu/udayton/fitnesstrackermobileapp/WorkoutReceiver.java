package edu.udayton.fitnesstrackermobileapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class WorkoutReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Handle the scheduled workout
        // This could be starting a notification, an activity, etc.
        Toast.makeText(context, "Time for your workout!", Toast.LENGTH_SHORT).show();
    }
}
