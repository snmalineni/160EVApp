package com.example.proj160v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =  (Button) findViewById(R.id.nextButton);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Schedule.class);
                name = editText.getText().toString();
                intent.putExtra("Name", name);
                startActivity(intent);
                finish();
            }
        });

    }

    /*

    public void openSchedule() {
        Intent intent = new Intent(this, Schedule.class);
        name = editText.getText().toString();
        intent.putExtra("NAME", name);
        startActivity(intent);
    }

     */






}
