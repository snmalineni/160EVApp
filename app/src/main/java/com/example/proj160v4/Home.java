package com.example.proj160v4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {

    private TextView scheduleTextView;
    private TextView chargeTextView;
    private EditText distanceEdit;
    private Button chargeButton;
    private Button chargeNowButton;
    private String chargeFinal;
    private Button scheduleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        scheduleTextView = (TextView) findViewById(R.id.scheduledText);
        final String scheduled = intent.getExtras().getString("Schedule");
        scheduleTextView.setText(scheduled);

        chargeTextView = (TextView) findViewById(R.id.chargeText);
        distanceEdit = (EditText) findViewById(R.id.distanceEdit);

        chargeButton = (Button) findViewById(R.id.chargeButton);

        chargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int distance = Integer.parseInt(distanceEdit.getText().toString());
             int charge = distance / 22;
             chargeFinal = String.valueOf(charge);
             chargeTextView.setText("Charge for: " + chargeFinal + " hours");

            }
        });

        chargeNowButton = (Button) findViewById(R.id.chargeNowButton);

        chargeNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Home.this, ChargeNow.class);
                //String chargeIntent = chargeTextView.getText().toString();
                intent2.putExtra("Charge", chargeFinal);
                intent2.putExtra("Schedule", scheduled);
                startActivity(intent2);
                finish();

            }
        });

        scheduleButton = findViewById(R.id.scheduleButton);

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Home.this, MainActivity.class);
                //String chargeIntent = chargeTextView.getText().toString();
                startActivity(intent3);
                finish();
            }

        });







    }
}
