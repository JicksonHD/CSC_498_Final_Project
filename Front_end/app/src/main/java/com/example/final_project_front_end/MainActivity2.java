package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    ImageView home_page_logo;
    EditText email;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        home_page_logo = (ImageView) findViewById(R.id.logo);
        email = (EditText) findViewById(R.id.emailAdress);
        pass = (EditText) findViewById(R.id.password);


        home_page_logo.setTranslationX(-1500);
        home_page_logo.animate().translationXBy(1500).setDuration(1500);
    }

    public void submit (View view){

        if ((email.getText().toString().equals("")) || (pass.getText().toString().equals(""))){

            Toast.makeText(getApplicationContext(),"Your email or password is missing",Toast.LENGTH_LONG).show();
        }
        else {
            if (pass.length() < 4){
                Toast.makeText(getApplicationContext(), "Your password is too short", Toast.LENGTH_LONG).show();
            }
            else {
                Intent general_features = new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(general_features);
            }
        }
    }
}