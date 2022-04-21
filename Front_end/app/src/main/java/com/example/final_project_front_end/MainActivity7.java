package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity7 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner services;
    TextView pick_services_hint;
    TextView services_result;
    EditText street;
    EditText building;
    EditText floor;
    EditText city;
    EditText time;
    String input_service,input_street,input_city,input_building,input_time,input_floor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        services = (Spinner) findViewById(R.id.services_spinner);
        services_result = (TextView) findViewById(R.id.services_result);
        pick_services_hint = (TextView) findViewById(R.id.pick_services_hint);
        street = (EditText) findViewById(R.id.street);
        building = (EditText) findViewById(R.id.building);
        floor = (EditText) findViewById(R.id.floor);
        city = (EditText) findViewById(R.id.city);
        time = (EditText) findViewById(R.id.time);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.services, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        services.setAdapter(adapter);
        services.setOnItemSelectedListener(MainActivity7.this);

        services.setTranslationX(-1500);
        services.animate().translationXBy(1500).setDuration(1500);

        street.setTranslationX(-1500);
        street.animate().translationXBy(1500).setDuration(1500);

        building.setTranslationX(-1500);
        building.animate().translationXBy(1500).setDuration(1500);

        floor.setTranslationX(-1500);
        floor.animate().translationXBy(1500).setDuration(1500);

        city.setTranslationX(-1500);
        city.animate().translationXBy(1500).setDuration(1500);

        time.setTranslationX(-1500);
        time.animate().translationXBy(1500).setDuration(1500);

        pick_services_hint.setTranslationX(-1500);
        pick_services_hint.animate().translationXBy(1500).setDuration(1500);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if (i == 0){
            input_service = "Plumber";
        }
        else if (i == 1){
            input_service = "Electrician";
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void order(View view){

        input_building = building.getText().toString();
        input_city = city.getText().toString();
        input_street = street.getText().toString();
        input_floor = floor.getText().toString();
        input_time = time.getText().toString();

        services_result.setText(input_service + " delivered at " + input_street + ", building " + input_building +  " " + input_floor + " floor " + " in\n" + input_city + " from " + input_time + " and will be available for 2 hours");




    }
}