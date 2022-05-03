package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class MainActivity8 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declaring variables
    TextView equipments_hint_spinner;
    Spinner equipments;
    TextView pick_equipments_hint;
    TextView equipments_result;
    EditText street;
    EditText building;
    EditText city;
    EditText time;
    Button order_equipment;
    ImageView imageView;
    String input_equipment,input_street,input_city,input_building,input_time;

    public class DownloadTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... params) {
            String equipment_name = params[0];
            String location_street= params[1];
            String location_building= params[2];
            String location_city= params[3];
            String time= params[4];

            URL url;
            HttpURLConnection http;

            try{
                url = new URL(params[5]);

                // Opening a connection between android app and the url
                http = (HttpURLConnection) url.openConnection();

                http.setRequestMethod("POST");
                http.setDoInput(true);
                http.setDoOutput(true);

                // I need an Output Stream to sent params to the API
                OutputStream out_stream = http.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out_stream, "UTF-8"));

                String post1 = URLEncoder.encode("equipment_name", "UTF-8")+"="+ URLEncoder.encode(equipment_name, "UTF-8")+"&"+URLEncoder.encode("location_street", "UTF-8")+"="+ URLEncoder.encode(location_street, "UTF-8")+"&"+URLEncoder.encode("location_building", "UTF-8")+"="+ URLEncoder.encode(location_building, "UTF-8")+"&"+URLEncoder.encode("location_city", "UTF-8")+"="+ URLEncoder.encode(location_city, "UTF-8")+"&"+URLEncoder.encode("time", "UTF-8")+"="+URLEncoder.encode(time, "UTF-8");
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
             //   Intent intent = new Intent(MainActivity3.this, MainActivity.class);
             //   startActivity(intent);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        //Initilizing variables
        equipments = (Spinner) findViewById(R.id.equipments_spinner);
        equipments_result = (TextView) findViewById(R.id.equipments_result);
        equipments_hint_spinner = (TextView) findViewById(R.id.equip_hint_spinner);
        pick_equipments_hint = (TextView) findViewById(R.id.pick_equipment_hint);
        street = (EditText) findViewById(R.id.street);
        building = (EditText) findViewById(R.id.building);
        city = (EditText) findViewById(R.id.city);
        time = (EditText) findViewById(R.id.time);
        order_equipment = (Button) findViewById(R.id.order_equipment);
        imageView = (ImageView) findViewById(R.id.imageView2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.equipments, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        equipments.setAdapter(adapter);
        equipments.setOnItemSelectedListener(MainActivity8.this);


        //Adding animation to spinner
        equipments.setTranslationX(-1500);
        equipments.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to street textBox
        street.setTranslationX(-1500);
        street.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to building textBox
        building.setTranslationX(-1500);
        building.animate().translationXBy(1500).setDuration(1500);


        //Adding animation to city textBox
        city.setTranslationX(-1500);
        city.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to time textBox
        time.setTranslationX(-1500);
        time.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to pick equipments hint
        pick_equipments_hint.setTranslationX(-1500);
        pick_equipments_hint.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to textView hint above spinner
        equipments_hint_spinner.setTranslationX(-1500);
        equipments_hint_spinner.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to order button
        order_equipment.setTranslationX(-1500);
        order_equipment.animate().translationXBy(1500).setDuration(1500);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //method  when item is selected in the spinner

        if (i == 0){
            input_equipment = "Concrete Mixer";
            imageView.setImageResource(R.drawable.concrete);
            imageView.setTranslationX(-1500);
            imageView.animate().translationXBy(1500).setDuration(1500);

            equipments_result.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
            time.setText("");


        }
        else if (i == 1){
            input_equipment = "ForkLift";
            imageView.setImageResource(R.drawable.forklift);
            imageView.setTranslationX(-1500);
            imageView.animate().translationXBy(1500).setDuration(1500);

            equipments_result.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
            time.setText("");


        }
        else if (i == 2){
            input_equipment = "BobCat";
            imageView.setImageResource(R.drawable.equipment);
            imageView.setTranslationX(-1500);
            imageView.animate().translationXBy(1500).setDuration(1500);

            equipments_result.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
            time.setText("");


        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void order(View view){
        //Onclick method of order button

        input_building = building.getText().toString();
        input_city = city.getText().toString();
        input_street = street.getText().toString();
        input_time = time.getText().toString();

        equipments_result.setText(input_equipment + " delivered at " + input_street + ", building  " + input_building + " in " + input_city + "\nFrom " + input_time + " and will be available for 2 hours");

    }
}