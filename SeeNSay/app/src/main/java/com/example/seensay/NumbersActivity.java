package com.example.seensay;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class NumbersActivity extends AppCompatActivity {

    ImageView number1;
    ImageView number2;
    ImageView number3;
    ImageView number4;
    ImageView number5;
    ImageView number6;
    ImageView number7;
    ImageView number8;
    ImageView number9;
    ImageView number10;
    ImageView number11;
    ImageView number12;
    ImageView number1pane;
    ImageView number2pane;
    ImageView number3pane;
    ImageView number4pane;
    ImageView number5pane;
    ImageView number6pane;
    ImageView number7pane;
    ImageView number8pane;
    ImageView number9pane;
    ImageView number10pane;
    ImageView number11pane;
    ImageView number12pane;
    ImageView[] numbers;
    int rando1;




    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbers_screen);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);
        number10 = findViewById(R.id.number10);
        number11 = findViewById(R.id.number11);
        number12 = findViewById(R.id.number12);

        button1 = findViewById(R.id.button1);

        number1pane = findViewById(R.id.number1pane);
        number2pane = findViewById(R.id.number2pane);
        number3pane = findViewById(R.id.number3pane);
        number4pane = findViewById(R.id.number4pane);
        number5pane = findViewById(R.id.number5pane);
        number6pane = findViewById(R.id.number6pane);
        number7pane = findViewById(R.id.number7pane);
        number8pane = findViewById(R.id.number8pane);
        number9pane = findViewById(R.id.number9pane);
        number10pane = findViewById(R.id.number10pane);
        number11pane = findViewById(R.id.number12pane);
        number12pane = findViewById(R.id.number12pane);

        numbers = new ImageView[12];
        numbers[0] = number1pane;
        numbers[1] = number2pane;
        numbers[2] = number3pane;
        numbers[3] = number4pane;
        numbers[4] = number5pane;
        numbers[5] = number6pane;
        numbers[6] = number7pane;
        numbers[7] = number8pane;
        numbers[8] = number9pane;
        numbers[9] = number10pane;
        numbers[10] = number11pane;
        numbers[11] = number12pane;
        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)

            @Override
            public void onClick(View v) {
                rando1 = 0;

                for (int i = 0; i < 12; i++) {
                    numbers[i].setBackgroundColor(-65281);
                    numbers[i].getBackground().setAlpha(0);
                }

                final Runnable flash = new Runnable() {
                    public void run() {
                        numbers[rando1].setBackgroundColor(-65281);
                        numbers[rando1].getBackground().setAlpha(0);
                        int rando2 = (int) (Math.random() * (12));
                        while (rando2 == rando1) {
                            rando2 = (int) (Math.random() * (12));
                        }
                        rando1 = rando2;
                        numbers[rando1].setBackgroundColor(-65281);
                        numbers[rando1].getBackground().setAlpha(50);
                        Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                        vib.vibrate(VibrationEffect.createOneShot(5, 255));

                    }
                };

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    int q = 0;

                    @Override
                    public void run() {
                        if (q < 20) {
                            runOnUiThread(flash);
                            q++;
                        } else

                            cancel();
                    }

                }, 0, 200);

            }
        });
    }


}