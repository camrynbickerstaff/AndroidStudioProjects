package com.example.greetings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView txt;
    Button btn;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.editText);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                count++;
                if(count%2==1)
                {
                    txt.setText("Hello");
                }
                else
                    txt.setText("Goodbye");

            }
        });

    }


}
