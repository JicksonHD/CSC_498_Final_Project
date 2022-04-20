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
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView material_hint_spinner;
    TextView material_order_result;
    ImageView material_logo;
    Spinner material;
    EditText quantity;
    EditText type;
    EditText street;
    EditText building;
    EditText city;
    Button order_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        material_hint_spinner = (TextView) findViewById(R.id.materials);
        material_logo = (ImageView) findViewById(R.id.imageView);
        material = (Spinner) findViewById(R.id.spinner1);
        quantity = (EditText) findViewById(R.id.quantity);
        type = (EditText) findViewById(R.id.type);
        street = (EditText) findViewById(R.id.street);
        building = (EditText) findViewById(R.id.building);
        city = (EditText) findViewById(R.id.city);
        order_button = (Button) findViewById(R.id.order_button);
        material_order_result = (TextView) findViewById(R.id.materials_result_order);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.materials, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        material.setAdapter(adapter);

        material.setOnItemSelectedListener(MainActivity6.this);

        material_logo.setTranslationX(-1500);

        material_hint_spinner.setTranslationX(-1500);
        material_hint_spinner.animate().translationXBy(1500).setDuration(1500);

        material.setTranslationX(-1500);
        material.animate().translationXBy(1500).setDuration(1500);

        quantity.setTranslationX(-1500);
        quantity.animate().translationXBy(1500).setDuration(1500);

        type.setTranslationX(-1500);
        type.animate().translationXBy(1500).setDuration(1500);

        street.setTranslationX(-1500);
        street.animate().translationXBy(1500).setDuration(1500);

        building.setTranslationX(-1500);
        building.animate().translationXBy(1500).setDuration(1500);

        city.setTranslationX(-1500);
        city.animate().translationXBy(1500).setDuration(1500);

        order_button.setTranslationX(-1500);
        order_button.animate().translationXBy(1500).setDuration(1500);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

       // String text = parent.getItemAtPosition(i).toString();
       // Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG).show();


        if (i == 0){
            material_logo.setTranslationX(-1500);
            material_logo.setImageResource(R.drawable.wood);
            material_logo.animate().translationXBy(1500).setDuration(1500);
            material_order_result.setText("");
            type.setText("");
            quantity.setText("");
            street.setText("");
            building.setText("");
            city.setText("");

        }
        else if (i == 1){
            material_logo.setTranslationX(-1500);
            material_logo.setImageResource(R.drawable.steel);
            material_logo.animate().translationXBy(1500).setDuration(1500);
            material_order_result.setText("");
            type.setText("");
            quantity.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
        }
        else if (i == 2){
            material_logo.setTranslationX(-1500);
            material_logo.setImageResource(R.drawable.cement);
            material_logo.animate().translationXBy(1500).setDuration(1500);
            material_order_result.setText("");
            type.setText("");
            quantity.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        material_logo.setTranslationX(-1500);

    }

    public void order (View view){

        String input_type = type.getText().toString();
        String input_quantity = quantity.getText().toString();
        String input_street = street.getText().toString();
        String input_city = city.getText().toString();


        material_order_result.setText(input_quantity + " kg of " + input_type + "\n" + "delivered at " + input_street + " in " + input_city);

    }

}