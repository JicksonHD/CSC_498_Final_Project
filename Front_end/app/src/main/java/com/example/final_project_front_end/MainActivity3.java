package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    //Declaring Variables
    ImageView home_page_logo;
    EditText email;
    EditText password;
    EditText confirm_password;
    EditText phone_number;
    TextView error_hint;
    Button register;

    public class DownloadTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... params) {
            String user_email = params[0];
            String user_password= params[1];
            String user_number = params[2];

            URL url;
            HttpURLConnection http;

            try{
                url = new URL(params[3]);

                // Opening a connection between android app and the url
                http = (HttpURLConnection) url.openConnection();

                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                // I need an Output Stream to sent params to the API
                OutputStream out_stream = http.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out_stream, "UTF-8"));

                String post1 = URLEncoder.encode("user_email", "UTF-8")+"="+ URLEncoder.encode(user_email, "UTF-8")+"&"+URLEncoder.encode("user_password", "UTF-8")+"="+ URLEncoder.encode(user_password, "UTF-8")+"&"+URLEncoder.encode("user_number", "UTF-8")+"="+ URLEncoder.encode(user_number, "UTF-8");
                bw.write(post1);
                bw.flush();
                bw.close();
                out_stream.close();

                // Reading the result from the API
                InputStream in_stream = http.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in_stream, "iso-8859-1"));
                String result = "";
                String line = "";
                while((line = br.readLine())!= null){
                    result += line;
                }
                br.close();
                in_stream.close();
                http.disconnect();
                return result;
            }
            catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            //If result incorrect print a toast
            if(result.equals("This account already exist")){
                Toast.makeText(getApplicationContext(),"This account already exist", Toast.LENGTH_LONG).show();

            }

            else{

                Toast.makeText(getApplicationContext(),"Account Created!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

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

        String entered_email = email.getText().toString();
        String entered_password = password.getText().toString();
        String entered_phone_number = phone_number.getText().toString();

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
                    String url = "http://192.168.26.1/Final_Project/Back_end/signUp.php";
                    DownloadTask task = new DownloadTask();
                    task.execute(entered_email, entered_password,entered_phone_number,url);
                }

            }
            else {
                error_hint.setText("");
                Toast.makeText(getApplicationContext(), "Make sure password confirmation is correct", Toast.LENGTH_LONG).show();
            }
        }
    }

}