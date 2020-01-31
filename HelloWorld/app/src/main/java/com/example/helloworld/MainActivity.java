package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity extends View{
    public static String MA = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w(MA, "View resource: " + R.layout.activity_main);

        int count = 0;
        for(int i = 0; i < 3; i++)
        {
            count++;
        }
    }
}
