package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity3 extends AppCompatActivity {

    //Declaring Variables
    ImageView home_page_logo;
    EditText email;
    EditText password;
    EditText confirm_password;
    EditText phone_number;
    TextView error_hint;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Initilizing variables
        email = (EditText) findViewById(R.id.emailAdressSignUp);
        password = (EditText) findViewById(R.id.passwordSignUp);
        confirm_password = (EditText) findViewById(R.id.confirmPassword);
        home_page_logo = (ImageView) findViewById(R.id.logo);
        error_hint = (TextView) findViewById(R.id.error_hint);
        register = (Button) findViewById(R.id.register);
        phone_number = (EditText) findViewById(R.id.phoneNumber);

        //Adding animation to home page logo
        home_page_logo.setTranslationX(-1500);
        home_page_logo.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to email TextBox
        email.setTranslationX(-1500);
        email.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to password TextBox
        password.setTranslationX(-1500);
        password.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to confirm password TextBox
        confirm_password.setTranslationX(-1500);
        confirm_password.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to phone number TextBox
        phone_number.setTranslationX(-1500);
        phone_number.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to register button
        register.setTranslationX(-1500);
        register.animate().translationXBy(1500).setDuration(1500);
    }

    public void register(View view){

        //Condition to make sure that the user has entered his\her credentials and confirmation of password
        if ((email.getText().toString().equals("") || (password.getText().toString().equals("")) || (phone_number.getText().toString().equals("")))){
            Toast.makeText(getApplicationContext(), "Your email,password,or number is missing", Toast.LENGTH_LONG).show();
        }
        else if (!(email.getText().toString().equals("") && !(password.getText().toString().equals("")))){

            if (password.getText().toString().equals(confirm_password.getText().toString())){
                if (password.length() < 4){

                    error_hint.setText("Your password must be greater than 4 characters");
                    Toast.makeText(getApplicationContext(),"Password too short",Toast.LENGTH_LONG).show();
                }else {
                    error_hint.setText("");
                    Intent home_page = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(home_page);
                }

            }
            else {
                error_hint.setText("");
                Toast.makeText(getApplicationContext(), "Make sure password confirmation is correct", Toast.LENGTH_LONG).show();
            }
        }
    }

}