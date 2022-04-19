package com.example.final_project_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    //Declaring variables
    EditText task_input;
    ListView task_list;
    TextView removeHint;
    Button addTask;
    ArrayList<String> theTask_list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        //Initilizing variables
        task_input = (EditText) findViewById(R.id.task_input);
        task_list = (ListView) findViewById(R.id.task_list);
        removeHint = (TextView) findViewById(R.id.removeHint);
        addTask = (Button) findViewById(R.id.addTask);
        theTask_list = new ArrayList<String>();
        adapter = new ArrayAdapter<String >(getApplicationContext(), android.R.layout.simple_list_item_1,theTask_list);

        //Setting adapter to task list
        task_list.setAdapter(adapter);

        //OnItemClickListener method that helps us to remove the clicked task
        task_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), theTask_list.get(i) + " Removed", Toast.LENGTH_LONG).show();
                theTask_list.remove(theTask_list.get(i));
                task_list.setAdapter(adapter);
            }
        });

        //Animation of input text box for task
        task_input.setTranslationX(-1500);
        task_input.animate().translationXBy(1500).setDuration(1500);

        //Animation of add task button
        addTask.setTranslationX(-1500);
        addTask.animate().translationXBy(1500).setDuration(1500);

        //Animation of textView hint at the bottom
        removeHint.setTranslationY(1500);
        removeHint.animate().translationYBy(-1500).setDuration(1500);



    }


    public void addTask(View view){
        //Method that allows us to add tasks to the list while clicking on button add task

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