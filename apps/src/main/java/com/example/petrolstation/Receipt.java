package com.example.petrolstation;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.petrolstation.database.DatabaseHelper;
import com.example.petrolstation.fragments.MapsFragment;
import com.example.petrolstation.ui.login.LoginActivity;

import java.util.List;

public class Receipt extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        Button backBtn = (Button)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Receipt.this, MainActivity.class));
            }
        });

        // Reading all
        Log.d("Reading: ", "Reading all Payments..");
        List<Payment> payments = db.getAllpayments();

        for (Payment cn : payments) {
//            String log = "Id: " + cn.getID() + " ,quantity: " + cn.getFuelQuantity() + " ,Fuel Type: " +
//                    cn.getFuelType()+",Total Price: "+ cn.getTotalPrice();
            // Writing payments to log
//            Log.d("Name: ", log);

        }
//        TextView fuelQuantity = (TextView) findViewById(R.id.fuelQuantity);
//        fuelQuantity.setText("Fuel Quantity"+cn.getFuelQuantity());
//        TextView fuelType = (TextView) findViewById(R.id.fuelType);
//        fuelType.setText("Fuel Type"+cn.getFuelType());
        TextView fuelPrice = (TextView) findViewById(R.id.fuelPrice);
        fuelPrice.setText("Fuel Price"+payments);
    }

}