package edu.udayton.fitnesstrackermobileapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutAudio extends AppCompatActivity {
    // Declare UI elements and MediaPlayer as class variables
    private Button track1Button;
    private Button track2Button;
    private Button track3Button;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass method and set the layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_audio);

        // Get references to UI elements
        track1Button = findViewById(R.id.track1Button);
        track2Button = findViewById(R.id.track2Button);
        track3Button = findViewById(R.id.track3Button);

        // Set click listeners for the buttons
        track1Button.setOnClickListener(v -> playTrack(R.raw.music1));
        track2Button.setOnClickListener(v -> playTrack(R.raw.music2));
        track3Button.setOnClickListener(v -> playTrack(R.raw.music3));
    }

    // Method to play a track
    private void playTrack(int resourceId) {
        // If a track is already playing, stop it and release the MediaPlayer
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        // Hide the buttons that are not associated with the current track
        track1Button.setVisibility(resourceId == R.raw.music1 ? View.VISIBLE : View.GONE);
        track2Button.setVisibility(resourceId == R.raw.music2 ? View.VISIBLE : View.GONE);
        track3Button.setVisibility(resourceId == R.raw.music3 ? View.VISIBLE : View.GONE);

        // Create a new MediaPlayer for the selected track and start playing
        mediaPlayer = MediaPlayer.create(this, resourceId);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        // Call the superclass method
        super.onDestroy();

        // If a track is playing, stop it and release the MediaPlayer
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
