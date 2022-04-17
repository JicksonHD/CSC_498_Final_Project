package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    ImageView home_page_logo;
    EditText email;
    EditText password;
    EditText confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        email = (EditText) findViewById(R.id.emailAdressSignUp);
        password = (EditText) findViewById(R.id.passwordSignUp);
        confirm_password = (EditText) findViewById(R.id.confirmPassword);


        home_page_logo = (ImageView) findViewById(R.id.logo);

        home_page_logo.setTranslationX(-1500);
        home_page_logo.animate().translationXBy(1500).setDuration(1500);
    }

    public void register(View view){

        if ((email.getText().toString().equals("") || (password.getText().toString().equals("")))){
            Toast.makeText(getApplicationContext(), "Your email or password is missing", Toast.LENGTH_LONG).show();
        }
        else if (!(email.getText().toString().equals("") && !(password.getText().toString().equals("")))){
            if (password.getText().toString().equals(confirm_password.getText().toString())){
                Intent home_page = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(home_page);
            }
            else {
                Toast.makeText(getApplicationContext(), "Make sure password confirmation is correct", Toast.LENGTH_LONG).show();
            }
        }
    }

}