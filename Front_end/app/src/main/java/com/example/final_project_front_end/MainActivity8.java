package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity8 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView equipments_hint_spinner;
    Spinner equipments;
    TextView pick_equipments_hint;
    TextView equipments_result;
    EditText street;
    EditText building;
    EditText city;
    EditText time;
    Button order_equipment;
    ImageView imageView;
    String input_equipment,input_street,input_city,input_building,input_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        equipments = (Spinner) findViewById(R.id.equipments_spinner);
        equipments_result = (TextView) findViewById(R.id.equipments_result);
        equipments_hint_spinner = (TextView) findViewById(R.id.equip_hint_spinner);
        pick_equipments_hint = (TextView) findViewById(R.id.pick_equipment_hint);
        street = (EditText) findViewById(R.id.street);
        building = (EditText) findViewById(R.id.building);
        city = (EditText) findViewById(R.id.city);
        time = (EditText) findViewById(R.id.time);
        order_equipment = (Button) findViewById(R.id.order_equipment);
        imageView = (ImageView) findViewById(R.id.imageView2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.equipments, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        equipments.setAdapter(adapter);
        equipments.setOnItemSelectedListener(MainActivity8.this);


        //Adding animation to spinner
        equipments.setTranslationX(-1500);
        equipments.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to street textBox
        street.setTranslationX(-1500);
        street.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to building textBox
        building.setTranslationX(-1500);
        building.animate().translationXBy(1500).setDuration(1500);


        //Adding animation to city textBox
        city.setTranslationX(-1500);
        city.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to time textBox
        time.setTranslationX(-1500);
        time.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to pick equipments hint
        pick_equipments_hint.setTranslationX(-1500);
        pick_equipments_hint.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to textView hint above spinner
        equipments_hint_spinner.setTranslationX(-1500);
        equipments_hint_spinner.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to order button
        order_equipment.setTranslationX(-1500);
        order_equipment.animate().translationXBy(1500).setDuration(1500);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if (i == 0){
            input_equipment = "Concrete Mixer";
            imageView.setImageResource(R.drawable.concrete);
            imageView.setTranslationX(-1500);
            imageView.animate().translationXBy(1500).setDuration(1500);

            equipments_result.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
            time.setText("");


        }
        else if (i == 1){
            input_equipment = "ForkLift";
            imageView.setImageResource(R.drawable.forklift);
            imageView.setTranslationX(-1500);
            imageView.animate().translationXBy(1500).setDuration(1500);

            equipments_result.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
            time.setText("");


        }
        else if (i == 2){
            input_equipment = "BobCat";
            imageView.setImageResource(R.drawable.equipment);
            imageView.setTranslationX(-1500);
            imageView.animate().translationXBy(1500).setDuration(1500);

            equipments_result.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
            time.setText("");


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void order(View view){

        input_building = building.getText().toString();
        input_city = city.getText().toString();
        input_street = street.getText().toString();
        input_time = time.getText().toString();

        equipments_result.setText(input_equipment + " delivered at " + input_street + ", building  " + input_building + " in " + input_city + "\nFrom " + input_time + " and will be available for 2 hours");

    }
}