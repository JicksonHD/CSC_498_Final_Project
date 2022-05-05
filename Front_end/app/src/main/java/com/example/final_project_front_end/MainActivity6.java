package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

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

import org.json.JSONArray;
import org.json.JSONObject;

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

public class MainActivity6 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declaring variables
    TextView material_hint_spinner;
    TextView material_order_result;
    ImageView material_logo;
    Spinner material;
    EditText quantity;
    EditText type;
    EditText street;
    EditText building;
    EditText city;
    Button order_button;
    String input_material;
    String [] remaining_quantity;

    public class DownloadTask extends AsyncTask<String, Void, String> {

        protected String doInBackground(String... params) {
            String material_name = params[0];
            String material_type= params[1];
            String material_quantity= params[2];
            String location_street= params[3];
            String location_building= params[4];
            String location_city= params[5];

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

                String post1 = URLEncoder.encode("material_name", "UTF-8")+"="+ URLEncoder.encode(material_name, "UTF-8")+"&"+URLEncoder.encode("material_type", "UTF-8")+"="+ URLEncoder.encode(material_type, "UTF-8")+"&"+URLEncoder.encode("material_quantity", "UTF-8")+"="+ URLEncoder.encode(material_quantity, "UTF-8")+"&"+URLEncoder.encode("location_street", "UTF-8")+"="+ URLEncoder.encode(location_street, "UTF-8")+"&"+URLEncoder.encode("location_building", "UTF-8")+"="+URLEncoder.encode(location_building, "UTF-8")+"&"+URLEncoder.encode("location_city", "UTF-8")+"="+URLEncoder.encode(location_city, "UTF-8");
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

            if (result.equals("Not enough quantity")){

                material_order_result.setText("");
                Toast.makeText(MainActivity6.this, "Not enough quantity", Toast.LENGTH_SHORT).show();
            }

            try{
                JSONArray array = new JSONArray(result);
                ArrayList<Object> list = new ArrayList<>();
                JSONObject obj;

                for (int i = 0; i < array.length(); i ++){
                    list.add(array.get(i));
                }
                // receiving the result from the api
                remaining_quantity = new String[array.length()];
                obj = (JSONObject) array.get(0);
                remaining_quantity[0] = obj.getString("quantity_available");
                Toast.makeText(MainActivity6.this,"Remaining: " + remaining_quantity[0], Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        //Initilizing variables
        material_hint_spinner = (TextView) findViewById(R.id.materials);
        material_logo = (ImageView) findViewById(R.id.imageView);
        material = (Spinner) findViewById(R.id.spinner1);
        quantity = (EditText) findViewById(R.id.quantity);
        type = (EditText) findViewById(R.id.type);
        street = (EditText) findViewById(R.id.street);
        building = (EditText) findViewById(R.id.building);
        city = (EditText) findViewById(R.id.city);
        order_button = (Button) findViewById(R.id.order_button);
        material_order_result = (TextView) findViewById(R.id.materials_result_order);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),R.array.materials, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the adapter to the material spinner
        material.setAdapter(adapter);

        //Setting on Item Selected Listener and linking it to the page
        material.setOnItemSelectedListener(MainActivity6.this);

        //Adding animation to the material  logo
        material_logo.setTranslationX(-1500);

        //Adding animation to the hint of material above spinner
        material_hint_spinner.setTranslationX(-1500);
        material_hint_spinner.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to the spinner
        material.setTranslationX(-1500);
        material.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to the quantity textBox
        quantity.setTranslationX(-1500);
        quantity.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to the type textBox
        type.setTranslationX(-1500);
        type.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to the street textBox
        street.setTranslationX(-1500);
        street.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to the building textBox
        building.setTranslationX(-1500);
        building.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to the city textBox
        city.setTranslationX(-1500);
        city.animate().translationXBy(1500).setDuration(1500);

        //Adding animation to the order button
        order_button.setTranslationX(-1500);
        order_button.animate().translationXBy(1500).setDuration(1500);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
        //Everytime i select an item of the spinner every textBox will be initilized to empty


        if (i == 0){
            //Adding animation to material logo and initlizing everything to empty

            input_material = "wood";
            material_logo.setTranslationX(-1500);
            material_logo.setImageResource(R.drawable.wood);
            material_logo.animate().translationXBy(1500).setDuration(1500);
            material_order_result.setText("");
            type.setText("");
            quantity.setText("");
            street.setText("");
            building.setText("");
            city.setText("");

        }
        else if (i == 1){
            //Adding animation to material logo and initlizing everything to empty

            input_material = "steel";
            material_logo.setTranslationX(-1500);
            material_logo.setImageResource(R.drawable.steel);
            material_logo.animate().translationXBy(1500).setDuration(1500);
            material_order_result.setText("");
            type.setText("");
            quantity.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
        }
        else if (i == 2){
            //Adding animation to material logo and initlizing everything to empty

            input_material = "cement";
            material_logo.setTranslationX(-1500);
            material_logo.setImageResource(R.drawable.cement);
            material_logo.animate().translationXBy(1500).setDuration(1500);
            material_order_result.setText("");
            type.setText("");
            quantity.setText("");
            street.setText("");
            building.setText("");
            city.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Adding animation to material logo to initially not be visible

        material_logo.setTranslationX(-1500);

    }

    public void order (View view){
        //Onclick method of order button

        String input_type = type.getText().toString();
        String input_quantity = quantity.getText().toString();
        String input_street = street.getText().toString();
        String input_city = city.getText().toString();
        String  input_building = building.getText().toString();


        material_order_result.setText(input_quantity + " kg of " + input_type + "\n" + "delivered at, " + input_street + " Building " + input_building + " in " + input_city);

        //Function posting parameters to database
        String url = "http://192.168.26.1/Final_Project/Back_end/materials.php";
        DownloadTask task = new DownloadTask();
        task.execute(input_material,input_type,input_quantity,input_street,input_building,input_city,url);

    }

}