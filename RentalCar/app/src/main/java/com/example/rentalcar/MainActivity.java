package com.example.rentalcar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner rentalDays_spinner;
    Spinner vehicleType_spinner;
    EditText numberOfDrivers_input;
    Spinner gas_spinner;
    Spinner driverInsured_spinner;
    TextView howmanydays;
    TextView whattype;
    TextView numberDrivers;
    TextView prepaygas;
    TextView insured;
    Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] days = { "1", "2", "3", "4", "5", "6", "7" };
        String[] vehicle = { "Jeep Wrangler", "Jeep Grand Cherokee", "Land Rover"};
        String[] yesNo = { "Yes", "No"};

        rentalDays_spinner = findViewById(R.id.rentalDays_spinner);
        vehicleType_spinner = findViewById(R.id.vehicleType_spinner);
        numberOfDrivers_input = findViewById(R.id.numberOfDrivers_input);
        gas_spinner = findViewById(R.id.gas_spinner);
        driverInsured_spinner = findViewById(R.id.driversInsured_spinner);
        howmanydays = findViewById(R.id.howmanydays);
        whattype = findViewById(R.id.whattype);
        numberDrivers = findViewById(R.id.numberDrivers);
        prepaygas = findViewById(R.id.prepaygas);
        insured = findViewById(R.id.insured);
        calculate = findViewById(R.id.calculate);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rentalDays_spinner.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vehicle);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleType_spinner.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yesNo);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        driverInsured_spinner.setAdapter(adapter3);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, yesNo);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gas_spinner.setAdapter(adapter4);

        calculate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                int cost = 0;
                int numDrivers = 1;
                int[] days = { 1,2,3,4,5,6,7 };
                int[] vehicle = { 55,85,125 };
                boolean[] yesorNo = { true,false};
                String[] yesNo = { "Yes", "No"};
                int selectedDays = days[rentalDays_spinner.getSelectedItemPosition()];
                int vehiclePrice = vehicle[vehicleType_spinner.getSelectedItemPosition()];
                boolean insured = yesorNo[driverInsured_spinner.getSelectedItemPosition()];
                boolean gas = yesorNo[gas_spinner.getSelectedItemPosition()];
                boolean valid = true;
                String numDrivers1 = numberOfDrivers_input.getText().toString();
                try {
                    numDrivers = Integer.parseInt(numDrivers1);
                }
                catch(NumberFormatException e) {
                    valid = false;
                }

                if( valid ) {
                    // use the number
                }
                else {
                    // handle invalid entry
                    return;
                }
                cost = cost + vehiclePrice*selectedDays;
                if(!insured)
                {
                    cost = cost + 24*selectedDays;
                }
                if(numDrivers > 1)
                {
                    cost = cost + 22*selectedDays;
                }
                if(gas)
                {
                    cost = cost + 52;
                }

                System.out.println(cost);
                Snackbar snackbar = Snackbar.make(findViewById(R.id.thisView), "Total Cost: $" + cost + ".00", Snackbar.LENGTH_LONG);
                Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout)snackbar.getView();
                layout.setMinimumHeight(300);//your custom height.
                TextView snackbarTextView = snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
                snackbarTextView.setTextSize( 40 );

                snackbar.show();



            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
