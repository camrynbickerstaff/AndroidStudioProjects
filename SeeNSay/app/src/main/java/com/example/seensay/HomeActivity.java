package com.example.seensay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button farmAnimals;
    Button numbers;
    Button forestAnimals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        farmAnimals = findViewById(R.id.farmAnimals);
        numbers = findViewById(R.id.numbers);
        forestAnimals = findViewById(R.id.forestAnimals);


        farmAnimals.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)

            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, FarmAnimalActivity.class);
                startActivity(i);

            }

        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)

            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, NumbersActivity.class);
                startActivity(i);

            }

        });

        forestAnimals.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)

            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ForestAnimalsActivity.class);
                startActivity(i);

            }

        });
    }
}