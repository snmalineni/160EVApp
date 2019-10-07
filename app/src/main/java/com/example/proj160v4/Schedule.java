package com.example.proj160v4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class Schedule extends AppCompatActivity {

    private TextView nameDisplay;
    private Button saveButton;
    private CalendarView calendarView;
    private TextView scheduleText;
    private String date;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Intent intent = getIntent();

        nameDisplay = (TextView) findViewById(R.id.nameDisplay);
        saveButton = (Button) findViewById(R.id.saveButton);
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        scheduleText = (TextView) findViewById(R.id.scheduleText);
        continueButton = (Button) findViewById(R.id.continueButton);



        String name = intent.getExtras().getString("Name");
        String name2 = "Hello " + name + "! Please Schedule Your Charge Below:";
        nameDisplay.setText(name2);

        calendarView.setOnDateChangeListener((new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                date = (month + 1) + "/" + dayOfMonth + "/" + year;
                Toast toast = Toast.makeText(getApplicationContext(), "Selected: " + date, Toast.LENGTH_SHORT);
                toast.show();

            }
        }));

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheduleText.setText("Scheduled: " + date);

            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Schedule.this, Time.class);
                String dateIntent = scheduleText.getText().toString();
                intent2.putExtra("Date", dateIntent);
                startActivity(intent2);
                finish();
            }
        });






    }
}
