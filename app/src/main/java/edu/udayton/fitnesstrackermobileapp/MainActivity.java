package edu.udayton.fitnesstrackermobileapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Array to store the names of the activities
    private final String[] activities = {"Running", "Cycling", "Strength Training", "Yoga"};

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass method and set the layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the ListView UI element
        ListView activityListView = findViewById(R.id.activity_list_view);

        // Create an ArrayAdapter to hold the activity names and set it to the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, activities);
        activityListView.setAdapter(adapter);

        // Set an item click listener for the ListView
        activityListView.setOnItemClickListener((parent, view, position, id) -> {
            // Get the name of the selected activity
            String selectedActivity = activities[position];

            // Create an intent to start the Detail activity, and put the activity name in the intent
            Intent intent = new Intent(MainActivity.this, Detail.class);
            intent.putExtra("activity_name", selectedActivity);
            startActivity(intent);
        });

        // Get a reference to the openWebPageButton UI element
        Button openWebPageButton = findViewById(R.id.openWebPageButton);

        // Set a click listener for the openWebPageButton
        openWebPageButton.setOnClickListener(v -> {
            // Create an intent to start the WebActivity
            Intent intent = new Intent(MainActivity.this, WebActivity.class);
            startActivity(intent);
        });
    }
}


