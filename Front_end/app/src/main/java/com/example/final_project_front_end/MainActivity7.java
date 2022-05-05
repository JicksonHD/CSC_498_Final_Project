package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity7 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declaring variables
    TextView services_hint_spinner;
    Spinner services;
    TextView pick_services_hint;
    TextView services_result;
    EditText street;
    EditText building;
    EditText floor;
    EditText city;
    EditText time;
    Button order_service;
    String input_service,input_street,input_city,input_building,input_time,input_floor;

    public class DownloadTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... params) {
            String services_name = params[0];
            String location_street= params[1];
            String location_building= params[2];
            String location_floor= params[3];
            String location_city= params[4];
            String time_arrival= params[5];

            URL url;
            HttpURLConnection http;

            try{
                url = new URL(params[6]);

                // Opening a connection between android app and the url
                http = (HttpURLConnection) url.openConnection();

                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                // I need an Output Stream to sent params to the API
                OutputStream out_stream = http.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out_stream, "UTF-8"));

                String post1 = URLEncoder.encode("services_name", "UTF-8")+"="+ URLEncoder.encode(services_name, "UTF-8")+"&"+URLEncoder.encode("location_street", "UTF-8")+"="+ URLEncoder.encode(location_street, "UTF-8")+"&"+URLEncoder.encode("location_building", "UTF-8")+"="+ URLEncoder.encode(location_building, "UTF-8")+"&"+URLEncoder.encode("location_floor", "UTF-8")+"="+ URLEncoder.encode(location_floor, "UTF-8")+"&"+URLEncoder.encode("location_city", "UTF-8")+"="+URLEncoder.encode(location_city, "UTF-8")+"&"+URLEncoder.encode("time_arrival", "UTF-8")+"="+URLEncoder.encode(time_arrival, "UTF-8");
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

            if (result.equals("Service currently unavailable")){

                services_result.setText("");
                Toast.makeText(MainActivity7.this, "Service currently unavailable", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        //Initilizing variables
        services = (Spinner) findViewById(R.id.equipments_spinner);
        services_result = (TextView) findViewById(R.id.equipments_result);
        pick_services_hint = (TextView) findViewById(R.id.pick_services_hint);
        street = (EditText) findViewById(R.id.street);
        building = (EditText) findViewById(R.id.building);
        floor = (EditText) findViewById(R.id.floor);
        city = (EditText) findViewById(R.id.city);
        time = (EditText) findViewById(R.id.time);
        order_service = (Button) findViewById(R.id.order_service);
        services_hint_spinner = (TextView) findViewById(R.id.services_hint_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.services, android.R.layout.simple_spinner_item);

        //Setting adapter as dropdown list
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Linking adapter with services spinner
        services.setAdapter(adapter);
        services.setOnItemSelectedListener(MainActivity7.this);

        //Adding animation to spinner
        services.setTranslationX(-1500);
        services.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to street textBox
        street.setTranslationX(-1500);
        street.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to building textBox
        building.setTranslationX(-1500);
        building.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to floor textBox
        floor.setTranslationX(-1500);
        floor.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to city textBox
        city.setTranslationX(-1500);
        city.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to time textBox
        time.setTranslationX(-1500);
        time.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to services hint
        pick_services_hint.setTranslationX(-1500);
        pick_services_hint.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to textView hint above spinner
        services_hint_spinner.setTranslationX(-1500);
        services_hint_spinner.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to order button
        order_service.setTranslationX(-1500);
        order_service.animate().translationXBy(1500).setDuration(1500);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //method  when item is selected in the spinner
        if (i == 0){
            input_service = "Plumber";
            services_result.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
            time.setText("");
            floor.setText("");
        }
        else if (i == 1){
            input_service = "Electrician";
            services_result.setText("");
            street.setText("");
            building.setText("");
            floor.setText("");
            city.setText("");
            time.setText("");

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //method when item is not selected in the spinner

    }

    public void order(View view){
        //Onclick method of order button

        input_building = building.getText().toString();
        input_city = city.getText().toString();
        input_street = street.getText().toString();
        input_floor = floor.getText().toString();
        input_time = time.getText().toString();

        services_result.setText(input_service + " delivered at " + input_street + ", building " + input_building +  " " + input_floor + " floor " + " in\n" + input_city + " from " + input_time + " and will be available for 2 hours");

        //Function posting parameters to database
        String url = "http://192.168.26.1/Final_Project/Back_end/services.php";
        DownloadTask task = new DownloadTask();
        task.execute(input_service,input_street,input_building,input_floor,input_city,input_time,url);




    }
}