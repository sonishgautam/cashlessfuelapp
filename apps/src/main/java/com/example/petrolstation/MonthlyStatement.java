package com.example.petrolstation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MonthlyStatement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_statement);

        Button julyBtn = (Button)findViewById(R.id.julyBtn);
        julyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MonthlyStatement.this, JulyReceipt.class));
            }
        });

        Button augBtn = (Button)findViewById(R.id.augBtn);
        augBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MonthlyStatement.this, JulyReceipt.class));
            }
        });
        Button sepBtn = (Button)findViewById(R.id.sepBtn);
        sepBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MonthlyStatement.this, JulyReceipt.class));
            }
        });
        Button novBtn = (Button)findViewById(R.id.octBtn);
        novBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MonthlyStatement.this, JulyReceipt.class));
            }
        });


        Button backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MonthlyStatement.this, MainActivity.class));
            }
        });

    }
}