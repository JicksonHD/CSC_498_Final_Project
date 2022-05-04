package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
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

public class MainActivity2 extends AppCompatActivity {

    //Declaring variables
    ImageView home_page_logo;
    EditText email;
    EditText pass;
    String [] user_id;
    SharedPreferences shared_preference;



    public class DownloadTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... params) {
            String user_email = params[0];
            String user_password= params[1];

            URL url;
            HttpURLConnection http;

            try{
                url = new URL(params[2]);

                // Opening a connection between android app and the url
                http = (HttpURLConnection) url.openConnection();

                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                // I need an Output Stream to sent params to the API
                OutputStream out_stream = http.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out_stream, "UTF-8"));

                String post1 = URLEncoder.encode("user_email", "UTF-8")+"="+ URLEncoder.encode(user_email, "UTF-8")+"&"+URLEncoder.encode("user_password", "UTF-8")+"="+ URLEncoder.encode(user_password, "UTF-8");
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
            if(result.equals("Incorrect Username or password")){
                Toast.makeText(getApplicationContext(),"Invalid Credentials", Toast.LENGTH_LONG).show();

           }
            // If result correct convert the received json object to string
            else{

                try{
                    JSONArray array = new JSONArray(result);
                    ArrayList<Object> list = new ArrayList<>();
                    JSONObject obj;

                    for (int i = 0; i < array.length(); i ++){
                        list.add(array.get(i));
                    }
                    user_id = new String[array.length()];
                    obj = (JSONObject) array.get(0);
                    user_id[0] = obj.getString("user_id");
                    shared_preference = getApplicationContext().getSharedPreferences("com.example.final_project_front_end", Context.MODE_PRIVATE);
                    shared_preference.edit().putString("user_id",user_id[0]).commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),"Welcome", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Initilizing variables
        home_page_logo = (ImageView) findViewById(R.id.logo);
        email = (EditText) findViewById(R.id.emailAdress);
        pass = (EditText) findViewById(R.id.password);

        //Adding animation to logo
        home_page_logo.setTranslationX(-1500);
        home_page_logo.animate().translationXBy(1500).setDuration(1500);
    }

    public void submit (View view){
        //Submit onclick method that allows the user to use the application

        String entered_email = email.getText().toString();
        String entered_password = pass.getText().toString();

        if ((email.getText().toString().equals("")) || (pass.getText().toString().equals(""))){

            Toast.makeText(getApplicationContext(),"Your email or password is missing",Toast.LENGTH_LONG).show();
        }
        else {

            //Function posting parameters to database
            String url = "http://192.168.26.1/Final_Project/Back_end/signIn.php";
            DownloadTask task = new DownloadTask();
            task.execute(entered_email, entered_password,url);

        }
    }
}