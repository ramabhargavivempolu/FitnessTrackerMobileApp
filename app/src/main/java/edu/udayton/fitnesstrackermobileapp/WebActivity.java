package edu.udayton.fitnesstrackermobileapp;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass method and set the layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        // Get a reference to the WebView UI element
        WebView myWebView = findViewById(R.id.webview);

        // Load a web page in the WebView
        myWebView.loadUrl("https://www.eatright.org/");
    }
}
