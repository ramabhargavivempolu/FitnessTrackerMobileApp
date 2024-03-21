package edu.udayton.fitnesstrackermobileapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UnitConversionActivity extends AppCompatActivity {

    // Declare UI elements as class variables
    private EditText unitInput;
    private Spinner unitSpinner;
    private TextView conversionResult;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass method and set the layout file
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_conversion);

        // Get references to UI elements
        unitInput = findViewById(R.id.unitInput);
        unitSpinner = findViewById(R.id.unitSpinner);
        Button convertButton = findViewById(R.id.convertButton);
        conversionResult = findViewById(R.id.conversionResult);

        // Set up the Spinner with unit conversion options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitSpinner.setAdapter(adapter);

        // Set a click listener for the convert button
        convertButton.setOnClickListener(v -> {
            // Get the input value and the selected unit
            String inputString = unitInput.getText().toString();
            String unit = unitSpinner.getSelectedItem().toString();

            // Check if the input is not empty
            if (!inputString.isEmpty()) {
                // Convert the input to double
                double inputValue = Double.parseDouble(inputString);
                double result;

                // Perform the conversion based on the selected unit
                switch (unit) {
                    case "Kilograms to Pounds":
                        result = inputValue * 2.20462;
                        break;
                    case "Pounds to Kilograms":
                        result = inputValue / 2.20462;
                        break;
                    case "Kilometers to Miles":
                        result = inputValue * 0.621371;
                        break;
                    case "Miles to Kilometers":
                        result = inputValue / 0.621371;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid unit type");
                }

                // Display the conversion result
                conversionResult.setText(String.valueOf(result));
            } else {
                // Display an error message if the input is empty
                conversionResult.setText("Please enter a value");
            }
        });
    }
}
