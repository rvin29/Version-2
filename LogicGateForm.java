package com.example.erovoutika;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogicGateForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic_gate_form);
        Button btn_backdashboard = (Button)findViewById(R.id.btn_backdashboard);
        Button btn_gates = findViewById(R.id.btn_selectgates);
        Button btn_circuits = (Button)findViewById(R.id.btn_IntegratedCircuit);
        Button btn_examples = (Button)findViewById(R.id.btn_examples);

        getSupportFragmentManager().beginTransaction().replace(R.id.logicgateform, new fragmentLogicGates()).commit();

        btn_backdashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogicGateForm.this, Dashboard.class);
                startActivity(intent);
            }
        });



            btn_circuits.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.logicgateform, new fragmentCircuit()).commit();
                }
            });

            btn_examples.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.logicgateform, new fragmentLogicExample()).commit();
                }
            });

            btn_gates.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.logicgateform, new fragmentLogicGates()).commit();
                }
            });

    }
}