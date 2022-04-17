package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    ImageView home_page_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        home_page_logo = (ImageView) findViewById(R.id.logo);


        home_page_logo.setTranslationX(-1500);
        home_page_logo.animate().translationXBy(1500).setDuration(1500);
    }
}