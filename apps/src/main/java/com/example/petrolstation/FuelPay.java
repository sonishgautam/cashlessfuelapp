package com.example.petrolstation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.petrolstation.database.DatabaseHelper;
import com.example.petrolstation.ui.login.LoginActivity;

import java.util.List;

public class FuelPay extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_pay);
        DatabaseHelper db = new DatabaseHelper(this);
        EditText fuelType = (EditText) findViewById(R.id.fuelType);
        EditText fuelPrice = (EditText) findViewById(R.id.fuelPrice);
        EditText fuelQuantity = (EditText) findViewById(R.id.fuelQuantity);

        Button mClickButton5 = (Button)findViewById(R.id.payButton);
        mClickButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inserting Payments
                Log.d("Insert: ", "Inserting ..");
                db.addPayment(new Payment(1, fuelQuantity.getText().toString(),fuelType.getText().toString(),fuelPrice.getText().toString()));
                startActivity(new Intent(FuelPay.this, CardForm.class));
            }
        });
    }

}