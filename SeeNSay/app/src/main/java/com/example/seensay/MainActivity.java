package com.example.seensay;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView cow4;
    ImageView cow2;
    ImageView cow5;
    ImageView cow6;
    ImageView cow7;
    ImageView cow8;
    ImageView cow9;
    ImageView cow10;
    ImageView cow11;
    ImageView cow12;
    ImageView cow13;
    ImageView cow14;
    ImageView cow2pane;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cow2 = findViewById(R.id.cow2);
        cow4 = findViewById(R.id.cow4);
        cow5 = findViewById(R.id.cow5);
        cow6 = findViewById(R.id.cow6);
        cow7 = findViewById(R.id.cow7);
        cow8 = findViewById(R.id.cow8);
        cow9 = findViewById(R.id.cow9);
        cow10 = findViewById(R.id.cow10);
        cow11 = findViewById(R.id.cow11);
        cow12 = findViewById(R.id.cow12);
        cow13 = findViewById(R.id.cow13);
        cow14 = findViewById(R.id.cow14);
        button1 = findViewById(R.id.button1);
        cow2pane = findViewById(R.id.cow2pane);

        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                cow2pane.setBackgroundColor(-65281);
                cow2pane.getBackground().setAlpha(50);
            }
        });
    }
}