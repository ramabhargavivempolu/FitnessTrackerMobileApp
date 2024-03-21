package edu.udayton.fitnesstrackermobileapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    // Define a constant for the delay duration (6000 milliseconds = 6 seconds)
    private static final long DELAY = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass method and set the layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Define a TimerTask to perform the task after a delay
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Finish the current activity
                finish();

                // Create an intent to start the MainActivity and start it
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        };

        // Create a Timer and schedule the task to run after the delay
        Timer opening = new Timer();
        opening.schedule(task, DELAY);
    }
}
