package com.example.petrolstation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.petrolstation.fragments.MapsFragment;

public class CardForm extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_form);

        Button mClickButton5 = (Button)findViewById(R.id.payButton);
        mClickButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardForm.this, LoyaltyPoints.class));
            }
        });
        Button  payButton2 = (Button)findViewById(R.id.payButton2);
        payButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CardForm.this, SuccessPage.class));
            }
        });

    }

}