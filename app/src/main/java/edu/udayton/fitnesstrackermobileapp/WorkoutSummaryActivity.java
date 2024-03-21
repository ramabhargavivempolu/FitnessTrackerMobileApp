package edu.udayton.fitnesstrackermobileapp;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import java.text.DateFormat;
import java.util.Date;

public class WorkoutSummaryActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass method and set the layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_summary);

        // Get references to UI elements
        TextView weightInputTextView = findViewById(R.id.weightInputTextView);
        TextView durationInputTextView = findViewById(R.id.durationInputTextView);
        TextView intensityInputTextView = findViewById(R.id.intensityInputTextView);
        TextView workoutStartTimeTextView = findViewById(R.id.workoutStartTimeTextView);
        TextView workoutEndTimeTextView = findViewById(R.id.workoutEndTimeTextView);

        // Get the shared preferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Set the text of the TextViews with the workout details from shared preferences
        weightInputTextView.setText("Weight: " + sharedPreferences.getString("weight", ""));
        durationInputTextView.setText("Duration: " + sharedPreferences.getString("duration", ""));
        intensityInputTextView.setText("Intensity: " + sharedPreferences.getString("intensity", ""));

        // Get the workout start and end times from shared preferences
        long workoutStartTime = sharedPreferences.getLong("startTime", 0);
        long workoutEndTime = sharedPreferences.getLong("endTime", 0);

        // Convert the workout start and end times to Date objects
        Date workoutStartDate = new Date(workoutStartTime);
        Date workoutEndDate = new Date(workoutEndTime);

        // Format the Date objects as strings
        String workoutStartDateStr = DateFormat.getDateTimeInstance().format(workoutStartDate);
        String workoutEndDateStr = DateFormat.getDateTimeInstance().format(workoutEndDate);

        // Set the text of the TextViews with the workout start and end times
        workoutStartTimeTextView.setText("Start Time: " + workoutStartDateStr);
        workoutEndTimeTextView.setText("End Time: " + workoutEndDateStr);
    }
}

