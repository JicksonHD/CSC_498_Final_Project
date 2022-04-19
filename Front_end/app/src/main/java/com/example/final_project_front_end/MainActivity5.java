package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    EditText task_input;
    ListView task_list;
    ArrayList<String> theTask_list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        task_input = (EditText) findViewById(R.id.task_input);
        task_list = (ListView) findViewById(R.id.task_list);
        theTask_list = new ArrayList<String>();
        adapter = new ArrayAdapter<String >(getApplicationContext(), android.R.layout.simple_list_item_1,theTask_list);

        task_list.setAdapter(adapter);

        task_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), theTask_list.get(i) + " Removed", Toast.LENGTH_LONG).show();
                theTask_list.remove(theTask_list.get(i));
                task_list.setAdapter(adapter);
            }
        });

    }


    public void addTask(View view){

        theTask_list.add(task_input.getText().toString());
        task_list.setAdapter(adapter);

    }

    /*
    public void removeTask(View view){

        task_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), theTask_list.get(i) + " Removed", Toast.LENGTH_LONG).show();
                theTask_list.remove(theTask_list.get(i));
                task_list.setAdapter(adapter);
            }
        });
    }

     */



}