package com.example.erovoutika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button btn_devices , btn_logicgate , btn_aboutus, btn_exit;
        btn_devices = (Button)findViewById(R.id.btn_devices);
        btn_logicgate = (Button)findViewById(R.id.btn_logicgates);
        btn_aboutus = (Button)findViewById(R.id.btn_aboutus);
        btn_exit = (Button)findViewById(R.id.btn_exit);

        btn_devices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, DevicesForm.class);
                startActivity(intent);
            }
        });

        btn_logicgate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, LogicGateForm.class);
                startActivity(intent);
            }
        });

    }
}