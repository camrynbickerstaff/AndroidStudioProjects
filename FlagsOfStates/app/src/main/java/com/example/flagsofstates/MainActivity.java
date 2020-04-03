package com.example.flagsofstates;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.service.autofill.Transformation;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView statePic;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    Button option5;
    Button play;
    ImageView correct;
    ImageView hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        statePic = findViewById(R.id.statePic);
        option1 = findViewById(R.id.option1);
        hint = findViewById(R.id.hint);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        option5 = findViewById(R.id.option5);
        correct = findViewById(R.id.correct);
        play = findViewById(R.id.play);
        statePic.setVisibility(View.GONE);
        correct.setVisibility(View.GONE);
        option1.setVisibility(View.GONE);
        option2.setVisibility(View.GONE);
        option3.setVisibility(View.GONE);
        option4.setVisibility(View.GONE);
        option5.setVisibility(View.GONE);

        play.setOnClickListener(new View.OnClickListener() {

            int lastState = 0;

            @Override
            public void onClick(View v) {
                play.setVisibility(View.GONE);
                play.setText("Play Again");
                statePic.setVisibility(View.VISIBLE);
                int state = 0;
                do {
                    state = (int) (Math.random() * (5) + 1);
                } while (state == lastState);
                lastState = state;
                System.out.println(state);
                switch (state) {
                    case 1:
                        statePic.setImageResource(R.mipmap.nevada);
                        hint.setMaxHeight(2);
                        break;
                    case 2:
                        statePic.setImageResource(R.mipmap.northcarolina);
                        hint.setMaxHeight(3);
                        break;
                    case 3:
                        statePic.setImageResource(R.mipmap.ohio);
                        hint.setMaxHeight(4);
                        break;
                    case 4:
                        statePic.setImageResource(R.mipmap.oklahoma);
                        hint.setMaxHeight(5);
                        break;
                    case 5:
                        statePic.setImageResource(R.mipmap.virginia);
                        hint.setMaxHeight(6);
                        break;
                }

                String[] stateNames = {"Nevada", "North Carolina", "Ohio", "Oklahoma", "Virginia"};
                String[] placement = {"", "", "", "", ""};
                int i = 0;
                while (i < 5) {
                    int randomPlacement = (int) (Math.random() * (5));
                    if (placement[randomPlacement].equals("")) {
                        placement[randomPlacement] = stateNames[i];
                        i++;
                    }
                }

                option1.setText(placement[0]);
                option2.setText(placement[1]);
                option3.setText(placement[2]);
                option4.setText(placement[3]);
                option5.setText(placement[4]);

                option1.setVisibility(View.VISIBLE);
                option2.setVisibility(View.VISIBLE);
                option3.setVisibility(View.VISIBLE);
                option4.setVisibility(View.VISIBLE);
                option5.setVisibility(View.VISIBLE);

            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                String[] stateNames = {"Nevada", "North Carolina", "Ohio", "Oklahoma", "Virginia"};
                int state = hint.getMaxHeight();
                String winner = "";
                switch (state) {
                    case 2:
                        winner = "Nevada";
                        break;
                    case 3:
                        winner = "North Carolina";
                        break;
                    case 4:
                        winner = "Ohio";
                        break;
                    case 5:
                        winner = "Oklahoma";
                        break;
                    case 6:
                        winner = "Virginia";
                        break;
                }

                if (option1.getText().equals(winner)) {
                    correct.setImageResource(R.mipmap.greencheck);
                }
                else
                    correct.setImageResource(R.mipmap.redx);

                final Runnable flash = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.VISIBLE);
                        option1.setVisibility(View.GONE);
                        option2.setVisibility(View.GONE);
                        option3.setVisibility(View.GONE);
                        option4.setVisibility(View.GONE);
                        option5.setVisibility(View.GONE);
                    }
                };
                final Runnable flash2 = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.GONE);
                        play.setVisibility(View.VISIBLE);

                    }
                };

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    int q = 0;

                    @Override
                    public void run() {
                        if (q % 2 == 0 && q < 2) {
                            runOnUiThread(flash);
                        } else if (q % 2 != 0 && q < 2) {
                            runOnUiThread(flash2);
                        }
                        q++;
                    }
                }, 0, 1500);

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                String[] stateNames = {"Nevada", "North Carolina", "Ohio", "Oklahoma", "Virginia"};
                int state = hint.getMaxHeight();
                String winner = "";
                switch (state) {
                    case 2:
                        winner = "Nevada";
                        break;
                    case 3:
                        winner = "North Carolina";
                        break;
                    case 4:
                        winner = "Ohio";
                        break;
                    case 5:
                        winner = "Oklahoma";
                        break;
                    case 6:
                        winner = "Virginia";
                        break;
                }

                if (option2.getText().equals(winner)) {
                    correct.setImageResource(R.mipmap.greencheck);
                } else
                    correct.setImageResource(R.mipmap.redx);

                final Runnable flash = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.VISIBLE);
                        option1.setVisibility(View.GONE);
                        option2.setVisibility(View.GONE);
                        option3.setVisibility(View.GONE);
                        option4.setVisibility(View.GONE);
                        option5.setVisibility(View.GONE);
                    }
                };
                final Runnable flash2 = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.GONE);
                        play.setVisibility(View.VISIBLE);

                    }
                };

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    int q = 0;

                    @Override
                    public void run() {
                        if (q % 2 == 0 && q < 2) {
                            runOnUiThread(flash);
                        } else if (q % 2 != 0 && q < 2) {
                            runOnUiThread(flash2);
                        }
                        q++;
                    }
                }, 0, 1500);

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                String[] stateNames = {"Nevada", "North Carolina", "Ohio", "Oklahoma", "Virginia"};
                int state = hint.getMaxHeight();
                String winner = "";
                switch (state) {
                    case 2:
                        winner = "Nevada";
                        break;
                    case 3:
                        winner = "North Carolina";
                        break;
                    case 4:
                        winner = "Ohio";
                        break;
                    case 5:
                        winner = "Oklahoma";
                        break;
                    case 6:
                        winner = "Virginia";
                        break;
                }

                if (option3.getText().equals(winner)) {
                    correct.setImageResource(R.mipmap.greencheck);
                } else
                    correct.setImageResource(R.mipmap.redx);

                final Runnable flash = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.VISIBLE);
                        option1.setVisibility(View.GONE);
                        option2.setVisibility(View.GONE);
                        option3.setVisibility(View.GONE);
                        option4.setVisibility(View.GONE);
                        option5.setVisibility(View.GONE);
                    }
                };
                final Runnable flash2 = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.GONE);
                        play.setVisibility(View.VISIBLE);

                    }
                };

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    int q = 0;

                    @Override
                    public void run() {
                        if (q % 2 == 0 && q < 2) {
                            runOnUiThread(flash);
                        } else if (q % 2 != 0 && q < 2) {
                            runOnUiThread(flash2);
                        }
                        q++;
                    }
                }, 0, 1500);

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                String[] stateNames = {"Nevada", "North Carolina", "Ohio", "Oklahoma", "Virginia"};
                int state = hint.getMaxHeight();
                String winner = "";
                switch (state) {
                    case 2:
                        winner = "Nevada";
                        break;
                    case 3:
                        winner = "North Carolina";
                        break;
                    case 4:
                        winner = "Ohio";
                        break;
                    case 5:
                        winner = "Oklahoma";
                        break;
                    case 6:
                        winner = "Virginia";
                        break;
                }

                if (option4.getText().equals(winner)) {
                    correct.setImageResource(R.mipmap.greencheck);
                }
                else
                    correct.setImageResource(R.mipmap.redx);

                final Runnable flash = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.VISIBLE);
                        option1.setVisibility(View.GONE);
                        option2.setVisibility(View.GONE);
                        option3.setVisibility(View.GONE);
                        option4.setVisibility(View.GONE);
                        option5.setVisibility(View.GONE);
                    }
                };
                final Runnable flash2 = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.GONE);
                        play.setVisibility(View.VISIBLE);

                    }
                };

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    int q = 0;

                    @Override
                    public void run() {
                        if (q % 2 == 0 && q < 2) {
                            runOnUiThread(flash);
                        } else if (q % 2 != 0 && q < 2) {
                            runOnUiThread(flash2);
                        }
                        q++;
                    }
                }, 0, 1500);

            }
        });

        option5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                String[] stateNames = {"Nevada", "North Carolina", "Ohio", "Oklahoma", "Virginia"};
                int state = hint.getMaxHeight();
                String winner = "";
                switch (state) {
                    case 2:
                        winner = "Nevada";
                        break;
                    case 3:
                        winner = "North Carolina";
                        break;
                    case 4:
                        winner = "Ohio";
                        break;
                    case 5:
                        winner = "Oklahoma";
                        break;
                    case 6:
                        winner = "Virginia";
                        break;
                }

                if (option5.getText().equals(winner)) {
                    correct.setImageResource(R.mipmap.greencheck);
                }
                else
                    correct.setImageResource(R.mipmap.redx);

                final Runnable flash = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.VISIBLE);
                        option1.setVisibility(View.GONE);
                        option2.setVisibility(View.GONE);
                        option3.setVisibility(View.GONE);
                        option4.setVisibility(View.GONE);
                        option5.setVisibility(View.GONE);
                    }
                };
                final Runnable flash2 = new Runnable() {
                    public void run() {
                        correct.setVisibility(View.GONE);
                        play.setVisibility(View.VISIBLE);

                    }
                };

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    int q = 0;

                    @Override
                    public void run() {
                        if (q % 2 == 0 && q < 2) {
                            runOnUiThread(flash);
                        } else if (q % 2 != 0 && q < 2) {
                            runOnUiThread(flash2);
                        }
                        q++;
                    }
                }, 0, 1500);

            }
        });
    }
}
