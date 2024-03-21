package edu.udayton.fitnesstrackermobileapp;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import java.util.Calendar;

public class Detail extends AppCompatActivity {

    // Variables to store the start and end time of the workout
    private long workoutStartTime;
    private long workoutEndTime;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Call the superclass method and set the layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Get references to UI elements
        ImageView activityImage = findViewById(R.id.activity_image);
        TextView activityDescription = findViewById(R.id.activity_description);
        EditText weightInput = findViewById(R.id.weight_input);
        EditText durationInput = findViewById(R.id.duration_input);
        Spinner intensitySpinner = findViewById(R.id.intensity_spinner);
        Button startTrackingButton = findViewById(R.id.start_tracking_button);
        Button scheduleWorkoutButton = findViewById(R.id.schedule_workout_button);
        Button playWorkoutAudioButton = findViewById(R.id.play_workout_audio_button);
        Button convertUnitsButton = findViewById(R.id.convert_units_button);
        Button viewSummaryButton = findViewById(R.id.view_summary_button);

        // Get the name of the activity from the intent
        String activityName = getIntent().getStringExtra("activity_name");

        // Set the description of the activity
        activityDescription.setText(activityName);

        // Set up the spinner for the intensity levels
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.intensity_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        intensitySpinner.setAdapter(adapter);

        // Define two click listeners for start and stop tracking
        final View.OnClickListener[] startTrackingClickListener = new View.OnClickListener[1];

        // Listener for stop tracking
        View.OnClickListener stopTrackingClickListener = v -> {
            // Capture the end time of the workout
            workoutEndTime = System.currentTimeMillis();
            long workoutDuration = workoutEndTime - workoutStartTime;
            startTrackingButton.setText("Start Tracking");
            startTrackingButton.setOnClickListener(startTrackingClickListener[0]);
            Toast.makeText(Detail.this, "Workout tracking stopped. Total duration: " + workoutDuration + " milliseconds", Toast.LENGTH_SHORT).show();

            // Save the workout details in shared preferences when tracking is stopped
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("weight", weightInput.getText().toString());
            editor.putString("duration", durationInput.getText().toString());
            editor.putString("intensity", intensitySpinner.getSelectedItem().toString());
            editor.putLong("startTime", workoutStartTime);
            editor.putLong("endTime", workoutEndTime);
            editor.apply();
        };

        // Listener for start tracking
        startTrackingClickListener[0] = v -> {
            // Capture the start time of the workout
            workoutStartTime = System.currentTimeMillis();
            startTrackingButton.setText("Stop Tracking");
            startTrackingButton.setOnClickListener(stopTrackingClickListener);
            Toast.makeText(Detail.this, "Workout tracking started", Toast.LENGTH_SHORT).show();
        };

        // Assign the start tracking listener to the start button
        startTrackingButton.setOnClickListener(startTrackingClickListener[0]);

        // Schedule a workout
        scheduleWorkoutButton.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog = new DatePickerDialog(Detail.this,
                    (view, selectedYear, selectedMonth, selectedDay) -> {
                        calendar.set(selectedYear, selectedMonth, selectedDay);
                        scheduleWorkout(calendar.getTimeInMillis());
                    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        // Start the WorkoutAudio activity
        playWorkoutAudioButton.setOnClickListener(v -> {
            Intent intent = new Intent(Detail.this, WorkoutAudio.class);
            startActivity(intent);
        });

        // Start the UnitConversion activity
        convertUnitsButton.setOnClickListener(v -> {
            Intent intent = new Intent(Detail.this, UnitConversionActivity.class);
            startActivity(intent);
        });

        // Start the WorkoutSummary activity
        viewSummaryButton.setOnClickListener(v -> {
            Intent intent = new Intent(Detail.this, WorkoutSummaryActivity.class);
            startActivity(intent);
        });
    }

    // Method to schedule a workout
    private void scheduleWorkout(long timeInMillis) {
        // Create an intent to start the WorkoutReceiver
        Intent intent = new Intent(Detail.this, WorkoutReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(Detail.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        // Get the AlarmManager and set a one-time alarm
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, timeInMillis, pendingIntent);

        // Show a toast message
        Toast.makeText(Detail.this, "Workout scheduled", Toast.LENGTH_SHORT).show();
    }
}
