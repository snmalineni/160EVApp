package com.example.proj160v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class Time extends AppCompatActivity {

    private TimePicker timePicker1;
    private TextView setTime;
    private Button setTimeButton;
    private String date;
    private String hourString;
    private String minString;
    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Intent intent = getIntent();

        date = intent.getExtras().getString("Date");


        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);

        setTimeButton = (Button) findViewById(R.id.setTimeButton);
        setTime = (TextView) findViewById(R.id.setTime);

        setTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = 24 - timePicker1.getHour() + 6;
                int min = timePicker1.getMinute();
                hourString = String.valueOf(hour);
                minString = String.valueOf(min);
                String finalSchedule = date + " " + "at " + hourString + ":" + minString;
                setTime.setText(finalSchedule);

            }
        });

        homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Time.this, Home.class);
                String scheduleIntent = setTime.getText().toString();
                intent2.putExtra("Schedule", scheduleIntent);
                startActivity(intent2);
                finish();
            }
        });
    }
}
