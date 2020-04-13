package com.example.seensay;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class WildlifeActivity extends AppCompatActivity {

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

    ImageView spinner;

    private MediaPlayer mMediaPlayer1;
    private MediaPlayer mMediaPlayer2;
    private MediaPlayer mMediaPlayer3;
    private MediaPlayer mMediaPlayer4;
    private MediaPlayer mMediaPlayer5;
    private MediaPlayer mMediaPlayer6;
    private MediaPlayer mMediaPlayer7;
    private MediaPlayer mMediaPlayer8;
    private MediaPlayer mMediaPlayer9;
    private MediaPlayer mMediaPlayer10;
    private MediaPlayer mMediaPlayer11;
    private MediaPlayer mMediaPlayer12;

    public int x;
    int rando1;




    Button button1;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wildlife_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mMediaPlayer1 = MediaPlayer.create(this, R.raw.baboon);
        mMediaPlayer2 = MediaPlayer.create(this, R.raw.bird);
        mMediaPlayer3 = MediaPlayer.create(this, R.raw.buffalo);
        mMediaPlayer4 = MediaPlayer.create(this, R.raw.crocodile);
        mMediaPlayer5 = MediaPlayer.create(this, R.raw.elephant);
        mMediaPlayer6 = MediaPlayer.create(this, R.raw.hippo);
        mMediaPlayer7 = MediaPlayer.create(this, R.raw.hyena);
        mMediaPlayer8 = MediaPlayer.create(this, R.raw.leopard);
        mMediaPlayer9 = MediaPlayer.create(this, R.raw.lion);
        mMediaPlayer10 = MediaPlayer.create(this, R.raw.rhino);
        mMediaPlayer11 = MediaPlayer.create(this, R.raw.snake);
        mMediaPlayer12 = MediaPlayer.create(this, R.raw.zebra2);

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
        spinner = findViewById(R.id.spinner);
        spinner.setVisibility(View.INVISIBLE);

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
                button1.setEnabled(false);
                rando1 = 0;
                button1.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.VISIBLE);
                RotateAnimation roA = new RotateAnimation(0, 720,
                        RotateAnimation.RELATIVE_TO_SELF, .5f,
                        RotateAnimation.RELATIVE_TO_SELF, .5f);
                roA.setDuration(4300);
                spinner.startAnimation(roA);

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

                        x = rando1;  // to use for which number to say and explode
                    }
                };

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    int q = 0;

                    @Override
                    public void run() {
                        if (q < 20) {
                            runOnUiThread(flash);
                            q++;
                        }
                        else {
                            //BUTTON CLICKABLE AGAIN
                            if (x == 0) {
                                mMediaPlayer1.start();
                                openActivity2(0);
                            } else if (x == 1) {
                                mMediaPlayer2.start();
                                openActivity2(1);
                            } else if (x == 2) {
                                mMediaPlayer3.start();
                                openActivity2(2);
                            } else if (x == 3) {
                                mMediaPlayer4.start();
                                openActivity2(3);
                            } else if (x == 4) {
                                mMediaPlayer5.start();
                                openActivity2(4);
                            } else if (x == 5) {
                                mMediaPlayer6.start();
                                openActivity2(5);
                            } else if (x == 6) {
                                mMediaPlayer7.start();
                                openActivity2(6);
                            } else if (x == 7) {
                                mMediaPlayer8.start();
                                openActivity2(7);
                            } else if (x == 8) {
                                mMediaPlayer9.start();
                                openActivity2(8);
                            } else if (x == 9) {
                                mMediaPlayer10.start();
                                openActivity2(9);
                            } else if (x == 10) {
                                mMediaPlayer12.start();
                                openActivity2(11);
                            } else if (x == 11) {
                                mMediaPlayer12.start();
                                openActivity2(11);
                            }

                            cancel();
                        }
                    }

                }, 0, 200);

            }
        });
    }

    // explodes the number that is landed on last
    public void openActivity2(int x){
        Intent intent;
        if (x == 0) intent = new Intent(this, baboonactivity.class);
        else if (x == 1) intent = new Intent(this, birdactivity.class);
        else if (x == 2) intent = new Intent(this, buffaloactivity.class);
        else if (x == 3) intent = new Intent(this, crocodileactivity.class);
        else if (x == 4) intent = new Intent(this, elephantactivity.class);
        else if (x == 5) intent = new Intent(this, hippoactivity.class);
        else if (x == 6) intent = new Intent(this, hyenaactivity.class);
        else if (x == 7) intent = new Intent(this, leopardactivity.class);
        else if (x == 8) intent = new Intent(this, lionactivity.class);
        else if (x == 9) intent = new Intent(this, rhinoactivity.class);
        else if (x == 10) intent = new Intent(this, snakeactivity.class);
        else intent = new Intent(this, zebraactivity.class);

        startActivity(intent);
        finish();
    }
}