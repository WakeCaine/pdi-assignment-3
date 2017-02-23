package com.example.main.timetolerance.appparts._main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.main.timetolerance.DataListActivity;
import com.example.main.timetolerance.appparts.loading.LoadingActivity;
import com.example.main.timetolerance.R;
import com.example.main.timetolerance.data.SavingData;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int timeInSecondsStartup = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timeInSecondsStartup = getIntent().getExtras().getInt("timeInSeconds");

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,
                        DataListActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button badButton = (Button) findViewById(R.id.badButton);
        Button okButton = (Button) findViewById(R.id.okButton);
        Button goodButton = (Button) findViewById(R.id.goodButton);
        badButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                String data = "StartUp Screen time: " + timeInSecondsStartup + " seconds , BAD, " + DateTime.now().toString("MM/dd/yyyy HH:mm");
                SaveNewData(data);

                LoadNextActivity();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                String data = "StartUp Screen time: " + timeInSecondsStartup + " seconds , OK, " + DateTime.now().toString("MM/dd/yyyy HH:mm");
                SaveNewData(data);

                LoadNextActivity();
            }
        });
        goodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                String data = "StartUp Screen time: " + timeInSecondsStartup + " seconds , GOOD, " + DateTime.now().toString("MM/dd/yyyy HH:mm");
                SaveNewData(data);

                LoadNextActivity();
            }
        });
    }

    void LoadNextActivity(){
        Intent i = new Intent(MainActivity.this,
                LoadingActivity.class);
        startActivity(i);
        finish();
    }

    void SaveNewData(String data){
        List<String> stringsList = SavingData.getData(getApplicationContext());
        if(!stringsList.isEmpty())
            stringsList.add(data);
        else
        {
            stringsList = new ArrayList<String>();
            stringsList.add(data);
        }
        SavingData.PushListData(getApplicationContext(), stringsList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
