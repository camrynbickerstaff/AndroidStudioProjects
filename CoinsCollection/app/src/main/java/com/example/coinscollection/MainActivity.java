package com.example.coinscollection;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText quarters;
    EditText dimes;
    EditText nickels;
    EditText pennies;
    TextView nametext;
    TextView quarterstext;
    TextView dimestext;
    TextView nickelstext;
    TextView penniestext;
    Button calculate;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        quarters = findViewById(R.id.quarters);
        dimes = findViewById(R.id.dimes);
        nickels = findViewById(R.id.nickels);
        pennies = findViewById(R.id.pennies);
        nametext = findViewById(R.id.nametext);
        quarterstext = findViewById(R.id.quarterstext);
        dimestext = findViewById(R.id.dimestext);
        nickelstext = findViewById(R.id.nickelstext);
        penniestext = findViewById(R.id.penniestext);
        calculate = findViewById(R.id.calculate);
        output = findViewById(R.id.output);

        calculate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                double total;
                int dollars;
                int cents;
                String inputname = name.getText().toString();
                int inputQ = Integer.parseInt(quarters.getText().toString());
                int inputD = Integer.parseInt(dimes.getText().toString());
                int inputN = Integer.parseInt(nickels.getText().toString());
                int inputP = Integer.parseInt(pennies.getText().toString());
                total = (25*inputQ + 10*inputD + 5*inputN + inputP);
                cents = (int) total%100;
                dollars =(int) (total - cents)/100;
                String sorno = "";
                if(cents == 1)
                {
                    sorno = "";
                }
                else
                    sorno = "s";

                String sorno2 = "";
                if(dollars == 1)
                {
                    sorno2 = "";
                }
                else
                    sorno2 = "s";
                String toOutput = "Hello " + inputname + "\n" + "Your coins are worth " + dollars + " dollar" + sorno2 + " and " + cents + " cent" + sorno + ". Bye!";

                output.setText(toOutput);
                output.setTextSize(18);



            }
        });

    }
}
