package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView material_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        material_logo = (ImageView) findViewById(R.id.imageView);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.materials, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(MainActivity6.this);

        material_logo.setTranslationX(-1500);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        
       // String text = parent.getItemAtPosition(i).toString();
       // Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG).show();


        if (i == 0){
            material_logo.setTranslationX(-1500);
            material_logo.setImageResource(R.drawable.wood);
            material_logo.animate().translationXBy(1500).setDuration(1500);
        }
        else if (i == 1){
            material_logo.setTranslationX(-1500);
            material_logo.setImageResource(R.drawable.steel);
            material_logo.animate().translationXBy(1500).setDuration(1500);
        }
        else if (i == 2){
            material_logo.setTranslationX(-1500);
            material_logo.setImageResource(R.drawable.cement);
            material_logo.animate().translationXBy(1500).setDuration(1500);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}