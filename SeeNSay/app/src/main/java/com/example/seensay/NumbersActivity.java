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

    int rando1;
    public int x;

    Button button1;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numbers_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        // for the audio files
        mMediaPlayer1 = MediaPlayer.create(this, R.raw.one);
        mMediaPlayer2 = MediaPlayer.create(this, R.raw.two);
        mMediaPlayer3 = MediaPlayer.create(this, R.raw.three);
        mMediaPlayer4 = MediaPlayer.create(this, R.raw.four);
        mMediaPlayer5 = MediaPlayer.create(this, R.raw.five);
        mMediaPlayer6 = MediaPlayer.create(this, R.raw.six);
        mMediaPlayer7 = MediaPlayer.create(this, R.raw.seven);
        mMediaPlayer8 = MediaPlayer.create(this, R.raw.eight);
        mMediaPlayer9 = MediaPlayer.create(this, R.raw.nine);
        mMediaPlayer10 = MediaPlayer.create(this, R.raw.ten);
        mMediaPlayer11 = MediaPlayer.create(this, R.raw.eleven);
        mMediaPlayer12 = MediaPlayer.create(this, R.raw.twelve);


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
        spinner = findViewById(R.id.spinner);
        spinner.setVisibility(View.INVISIBLE);

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

                        x = rando1;  // to use for which number to say and explode
                    }
                };

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    int q = 0;

                    @Override
                    public void run() {
                       // once the random flash is done say and explode the final number
                        if (q < 20) {
                            runOnUiThread(flash);
                            q++;
                        }
                        else {
                            //BUTTON CLICKABLE AGAIN
                            if (x == 0)
                            {
                                mMediaPlayer1.start();
                                openActivity2(0);
                            }
                            else if (x == 1)
                            {
                                mMediaPlayer2.start();
                                openActivity2(1);
                            }
                            else if(x == 2)
                            {
                                mMediaPlayer3.start();
                                openActivity2(2);
                            }
                            else if (x == 3)
                            {
                                mMediaPlayer4.start();
                                openActivity2(3);
                            }
                            else if (x == 4)
                            {
                                mMediaPlayer5.start();
                                openActivity2(4);
                            }
                            else if (x == 5)
                            {
                                mMediaPlayer6.start();
                                openActivity2(5);
                            }
                            else if (x == 6)
                            {
                                mMediaPlayer7.start();
                                openActivity2(6);
                            }
                            else if (x == 7)
                            {
                                mMediaPlayer8.start();
                                openActivity2(7);
                            }
                            else if (x == 8)
                            {
                                mMediaPlayer9.start();
                                openActivity2(8);
                            }
                            else if (x == 9)
                            {
                                mMediaPlayer10.start();
                                openActivity2(9);
                            }
                            else if (x == 10)
                            {
                                mMediaPlayer12.start();
                                openActivity2(11);
                            }
                            else if (x == 11)
                            {
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
        if (x == 0) intent = new Intent(this, oneexplode.class);
        else if (x == 1) intent = new Intent(this, twoexplode.class);
        else if (x == 2) intent = new Intent(this, threeexplode.class);
        else if (x == 3) intent = new Intent(this, fourexplode.class);
        else if (x == 4) intent = new Intent(this, fiveexplode.class);
        else if (x == 5) intent = new Intent(this, sixexplode.class);
        else if (x == 6) intent = new Intent(this, sevenexplode.class);
        else if (x == 7) intent = new Intent(this, eightexplode.class);
        else if (x == 8) intent = new Intent(this, nineexplode.class);
        else if (x == 9) intent = new Intent(this, tenexplode.class);
        else if (x == 10) intent = new Intent(this, twelveexplode.class);
        else intent = new Intent(this, twelveexplode.class);

        startActivity(intent);
        finish();
    }
}