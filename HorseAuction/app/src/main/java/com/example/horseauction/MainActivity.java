package com.example.horseauction;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView abbypic;
    ImageView rascalpic;
    ImageView bothpic;
    Button abby;
    Button rascal;
    Button both;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abbypic = findViewById(R.id.abbypic);
        abby = findViewById(R.id.abby);
        rascalpic = findViewById(R.id.rascalpic);
        rascal = findViewById(R.id.rascal);
        bothpic = findViewById(R.id.bothpic);
        both = findViewById(R.id.both);
        abby.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                abbypic.setImageResource(R.mipmap.mystery);
                rascalpic.setImageResource(R.mipmap.star);
                bothpic.setImageResource(R.mipmap.star);

            }

        });

        rascal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                abbypic.setImageResource(R.mipmap.star);
                rascalpic.setImageResource(R.mipmap.maximus);
                bothpic.setImageResource(R.mipmap.star);
            }

        });

        both.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                abbypic.setImageResource(R.mipmap.star);
                rascalpic.setImageResource(R.mipmap.star);
                bothpic.setImageResource(R.mipmap.bothhorses);
            }

        });
    }
}
