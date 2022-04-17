package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView home_page_logo;
    Button log_in;
    Button register;
    TextView help;
    TextView registration_hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home_page_logo = (ImageView) findViewById(R.id.logo);
        log_in = (Button) findViewById(R.id.sign_in);
        register = (Button) findViewById(R.id.sign_up);
        help = (TextView) findViewById(R.id.here_to_help);
        registration_hint = (TextView) findViewById(R.id.textView_for_signup);

        home_page_logo.setTranslationX(-1500);
        home_page_logo.animate().translationXBy(1500).setDuration(1500);

        log_in.setTranslationX(-1500);
        log_in.animate().translationXBy(1500).setDuration(1500);

        register.setTranslationX(-1500);
        register.animate().translationXBy(1500).setDuration(1500);

        help.setTranslationY(1500);
        help.animate().translationYBy(-1500).setDuration(1500);

        registration_hint.setTranslationX(-1500);
        registration_hint.animate().translationXBy(1500).setDuration(1500);
    }


}