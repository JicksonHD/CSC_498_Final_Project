package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Declaring variables
    ImageView home_page_logo;
    Button log_in;
    Button register;
    TextView help;
    TextView registration_hint;
    TextView signIn_proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initilizing variables
        home_page_logo = (ImageView) findViewById(R.id.logo);
        log_in = (Button) findViewById(R.id.sign_in);
        register = (Button) findViewById(R.id.sign_up);
        help = (TextView) findViewById(R.id.here_to_help);
        registration_hint = (TextView) findViewById(R.id.textView_for_signup);
        signIn_proceed = (TextView) findViewById(R.id.proceed_message);

        //Adding animation to logo
        home_page_logo.setTranslationX(-1500);
        home_page_logo.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to sign in button
        log_in.setTranslationX(-1500);
        log_in.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to sign up button
        register.setTranslationX(-1500);
        register.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to Bottom help textView
        help.setTranslationY(1500);
        help.animate().translationYBy(-1500).setDuration(1500);

        //Adding animation to hint for sign up if you don't have an account TextView
        registration_hint.setTranslationX(-1500);
        registration_hint.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to hint for sign in to proceed
        signIn_proceed.setTranslationX(-1500);
        signIn_proceed.animate().translationXBy(1500).setDuration(1500);

    }

    public void signIn(View view){

        Intent signIn_page = new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(signIn_page);
    }

    public void signUp(View view){

        Intent signUp_page = new Intent(getApplicationContext(),MainActivity3.class);
        startActivity(signUp_page);
    }


}