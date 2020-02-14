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

public class ForestAnimalsActivity extends AppCompatActivity {

    ImageView animal1;
    ImageView animal2;
    ImageView animal3;
    ImageView animal4;
    ImageView animal5;
    ImageView animal6;
    ImageView animal7;
    ImageView animal8;
    ImageView animal9;
    ImageView animal10;
    ImageView animal11;
    ImageView animal12;
    ImageView animal1pane;
    ImageView animal2pane;
    ImageView animal3pane;
    ImageView animal4pane;
    ImageView animal5pane;
    ImageView animal6pane;
    ImageView animal7pane;
    ImageView animal8pane;
    ImageView animal9pane;
    ImageView animal10pane;
    ImageView animal11pane;
    ImageView animal12pane;
    ImageView[] animals;
    int rando1;




    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forest_animals_screen);

        animal1 = findViewById(R.id.animal1);
        animal2 = findViewById(R.id.animal2);
        animal3 = findViewById(R.id.animal3);
        animal4 = findViewById(R.id.animal4);
        animal5 = findViewById(R.id.animal5);
        animal6 = findViewById(R.id.animal6);
        animal7 = findViewById(R.id.animal7);
        animal8 = findViewById(R.id.animal8);
        animal9 = findViewById(R.id.animal9);
        animal10 = findViewById(R.id.animal10);
        animal11 = findViewById(R.id.animal11);
        animal12 = findViewById(R.id.animal12);

        button1 = findViewById(R.id.button1);

        animal1pane = findViewById(R.id.animal1pane);
        animal2pane = findViewById(R.id.animal2pane);
        animal3pane = findViewById(R.id.animal3pane);
        animal4pane = findViewById(R.id.animal4pane);
        animal5pane = findViewById(R.id.animal5pane);
        animal6pane = findViewById(R.id.animal6pane);
        animal7pane = findViewById(R.id.animal7pane);
        animal8pane = findViewById(R.id.animal8pane);
        animal9pane = findViewById(R.id.animal9pane);
        animal10pane = findViewById(R.id.animal10pane);
        animal11pane = findViewById(R.id.animal12pane);
        animal12pane = findViewById(R.id.animal12pane);

        animals = new ImageView[12];
        animals[0] = animal1pane;
        animals[1] = animal2pane;
        animals[2] = animal3pane;
        animals[3] = animal4pane;
        animals[4] = animal5pane;
        animals[5] = animal6pane;
        animals[6] = animal7pane;
        animals[7] = animal8pane;
        animals[8] = animal9pane;
        animals[9] = animal10pane;
        animals[10] = animal11pane;
        animals[11] = animal12pane;
        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)

            @Override
            public void onClick(View v) {
                rando1 = 0;

                for (int i = 0; i < 12; i++) {
                    animals[i].setBackgroundColor(-65281);
                    animals[i].getBackground().setAlpha(0);
                }

                final Runnable flash = new Runnable() {
                    public void run() {
                        animals[rando1].setBackgroundColor(-65281);
                        animals[rando1].getBackground().setAlpha(0);
                        int rando2 = (int) (Math.random() * (12));
                        while (rando2 == rando1) {
                            rando2 = (int) (Math.random() * (12));
                        }
                        rando1 = rando2;
                        animals[rando1].setBackgroundColor(-65281);
                        animals[rando1].getBackground().setAlpha(50);
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