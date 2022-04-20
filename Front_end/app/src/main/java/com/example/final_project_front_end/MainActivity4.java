package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    //Declaring Variables
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

        //Initilizing variables
        materials = (Button) findViewById(R.id.materialsButton);
        tasks = (Button) findViewById(R.id.taskButton);
        services = (Button) findViewById(R.id.servicesButton);
        equipments = (Button) findViewById(R.id.equipmentButton);
        hint = (TextView) findViewById(R.id.hinttextView);
        helmet_logo = (ImageView) findViewById(R.id.helmetLogo);

        //Adding animation to materials button
        materials.setTranslationX(-1500);
        materials.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to tasks button
        tasks.setTranslationX(-1500);
        tasks.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to services button
        services.setTranslationX(-1500);
        services.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to equipments button
        equipments.setTranslationX(-1500);
        equipments.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to helmet image
        helmet_logo.setTranslationX(-1500);
        helmet_logo.animate().translationXBy(1500).setDuration(1500);

    }


    public void takeMeToMaterials(View view){
        //Onclick method that takes us to the material page

        Intent materials_page = new Intent(getApplicationContext(),MainActivity6.class);
        startActivity(materials_page);
    }

    public void takeMeToEquip(View view){
        //Onclick method that takes us to the equipment page


        // Intent equipment_page = new Intent(getApplicationContext(),);
    }

    public void takeMeToTasks(View view){
        //Onclick method that takes us to the Tasks page


         Intent tasks_page = new Intent(getApplicationContext(),MainActivity5.class);
         startActivity(tasks_page);
    }

    public void takeMeToServices(View view){
        //Onclick method that takes us to the services page


         Intent services_page = new Intent(getApplicationContext(),MainActivity7.class);
         startActivity(services_page);
    }
}