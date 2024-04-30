package com.example.unitconverter;

import static android.provider.SyncStateContract.Helpers.update;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText input;
    Spinner unit;

    TextView km,m,cm,microm,nm,mile,yard,foot;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);
        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        microm = findViewById(R.id.microm);
        nm = findViewById(R.id.nm);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
        foot = findViewById(R.id.foot);

        String[] arr = {"km","m","cm","microm","nm","mile","yard","foot"};

        unit.setAdapter( new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arr));


        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                update();

            }

            private void update() {
            }
        });


    }

    private void update(){

        if (!input.getText().toString().equals("") && !unit.getSelectedItem().toString().equals("")){


            double in = Double.parseDouble((input.getText().toString()));
            switch (unit.getSelectedItem().toString()){

                case "km":
                    setKm(in);
                    break;

                case "m":
                    setKm(in/1000);
                    break;

                case "cm":
                    setKm(in/100000);
                    break;

                case "microm":
                    setKm(in/1000000000);
                    break;

                case "nm":
                    double Double = 1000000 * 1000000;
                    setKm(in/Double);
                    break;

                case "mile":
                    setKm(in*1.609);
                    break;

                case "yard":
                    setKm(in/1094);
                    break;

                case "foot":
                    setKm(in/3281);
                    break;

            }
        }


    }

    private void setKm(double km_in) {

        km.setText(String.valueOf(km_in));
        m.setText(String.valueOf(km_in*1000));
        cm.setText(String.valueOf(km_in*100000));
        microm.setText(String.valueOf(km_in*1000000));
        nm.setText(String.valueOf(km_in*1000000 * 1000000));
        mile.setText(String.valueOf(km_in/1.609));
        yard.setText(String.valueOf(km_in*1094));
        foot.setText(String.valueOf(km_in*3281));



    }
}