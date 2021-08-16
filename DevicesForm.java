package com.example.erovoutika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class DevicesForm extends AppCompatActivity {
    public Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices_form);
        Button btnback = (Button) findViewById(R.id.btn_back);
        Button btn_sensor = (Button) findViewById(R.id.btn_Sensor);
        Button btn_diode = (Button)findViewById(R.id.btn_diode);
        Button btn_led = (Button)findViewById(R.id.btn_LED);


        getSupportFragmentManager().beginTransaction().replace(R.id.devicesform, new mainFragment()).commit();

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DevicesForm.this, Dashboard.class);
                startActivity(intent);
            }
        });


        btn_sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.devicesform, new SensorFragment()).commit();
            }
        });

        btn_diode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.devicesform, new DiodeFragment()).commit();
            }
        });

        btn_led.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.devicesform, new mainFragment()).commit();
            }
        });
    }


}