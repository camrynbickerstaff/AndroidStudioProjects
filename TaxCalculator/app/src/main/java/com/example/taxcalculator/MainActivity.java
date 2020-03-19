package com.example.taxcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView title;
    RadioGroup group;
    TextView FilingStatus;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    TextView title2;
    TextView decimal;
    TextView money;
    EditText income;
    EditText decimalnum;
    Button button;
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.title);
        group = findViewById(R.id.group);
        FilingStatus = findViewById(R.id.FilingStatus);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        title2 = findViewById(R.id.title2);
        decimal = findViewById(R.id.decimal);
        money = findViewById(R.id.money);
        income = findViewById(R.id.income);
        decimalnum = findViewById(R.id.decimalnum);
        button = findViewById(R.id.button);
        output = findViewById(R.id.output);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                double incomeNum;
                int incomeNum1 = 0;
                double toOutput = 0;
                double decimal;
                String input1 = income.getText().toString();
                String input2 = decimalnum.getText().toString();
                if(input1.equals(""))
                {
                    incomeNum = 0;
                }
                else
                {
                    incomeNum = Integer.parseInt(input1);
                }
                if(input2.equals(""))
                {
                    decimal = 0;
                }
                else
                {
                    decimal = (double)Integer.parseInt(input2)/100;
                }
                System.out.println(decimal);
                incomeNum1 = (int)incomeNum;
                if(decimal > 0)
                {
                    incomeNum1 = (int)(incomeNum + 1);
                }
                incomeNum = incomeNum + decimal;
                System.out.println(incomeNum1);
                System.out.println(incomeNum);
                if(radioButton.isChecked() && incomeNum1 > 49300)
                {
                    toOutput = 11158.50 + (incomeNum-49300)*.31;
                }
                else if(radioButton2.isChecked() && incomeNum1 > 34000)
                {
                    if(incomeNum1 < 82150)
                    {
                        toOutput = 5100 + (incomeNum-34000)*.28;
                    }
                    else
                    {
                        toOutput = 18582 + (incomeNum-82150)*.31;
                    }
                }
                else if(radioButton3.isChecked() && incomeNum1 > 41075)
                {
                    toOutput = 9291 + (incomeNum-41075)*.31;
                }
                else if(radioButton4.isChecked() && incomeNum1 > 27300)
                {
                    if(incomeNum1 < 70450)
                    {
                        toOutput = 4095 + (incomeNum-27300)*.28;
                    }
                    else
                    {
                        toOutput = 16177 + (incomeNum-70450)*.31;
                    }
                }
                String outputText = "";
                if(toOutput == 0)
                {
                    outputText = "Your taxes cannot be calculated using this calculator";
                }
                else
                {
                    String str = NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(toOutput);
                    outputText = "Tax: " + str;
                }
                output.setText(outputText);
                output.setTextSize(18);



            }
        });
    }
}
