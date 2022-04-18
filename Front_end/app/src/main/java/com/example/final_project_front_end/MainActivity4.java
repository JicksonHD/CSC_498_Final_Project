package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    Button materials;
    Button tasks;
    Button services;
    Button equipments;
    TextView hint;
    ImageView helmet_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        materials = (Button) findViewById(R.id.materialsButton);
        tasks = (Button) findViewById(R.id.taskButton);
        services = (Button) findViewById(R.id.servicesButton);
        equipments = (Button) findViewById(R.id.equipmentButton);
        hint = (TextView) findViewById(R.id.hinttextView);
        helmet_logo = (ImageView) findViewById(R.id.helmetLogo);

        materials.setTranslationX(-1500);
        materials.animate().translationXBy(1500).setDuration(1500);

        tasks.setTranslationX(-1500);
        tasks.animate().translationXBy(1500).setDuration(1500);

        services.setTranslationX(-1500);
        services.animate().translationXBy(1500).setDuration(1500);

        equipments.setTranslationX(-1500);
        equipments.animate().translationXBy(1500).setDuration(1500);

        helmet_logo.setTranslationX(-1500);
        helmet_logo.animate().translationXBy(1500).setDuration(1500);




    }
}