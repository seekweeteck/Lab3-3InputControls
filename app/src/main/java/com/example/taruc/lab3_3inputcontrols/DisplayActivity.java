package com.example.taruc.lab3_3inputcontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //Create the text view
        TextView textViewOutput = new TextView(this);
        textViewOutput.setTextSize(30);
        textViewOutput.setText(message);

        //Set the text view as the activity layout
        setContentView(textViewOutput);
    }
}
