package com.example.main.timetolerance.appparts.loading;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.main.timetolerance.DataListActivity;
import com.example.main.timetolerance.R;
import com.example.main.timetolerance.appparts.textupdate.TextUpdateActivity;
import com.example.main.timetolerance.data.SavingData;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class LoadingAnswersActivity extends AppCompatActivity {
    int timeInSecondsLoading = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timeInSecondsLoading = getIntent().getExtras().getInt("timeInSeconds");
        setContentView(R.layout.activity_loading_answers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoadingAnswersActivity.this,
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
                String data = "Loading Screen time: " + timeInSecondsLoading + " seconds , BAD, " + DateTime.now().toString("MM/dd/yyyy HH:mm");
                SaveNewData(data);
                LoadNextActivity();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                String data = "Loading Screen time: " + timeInSecondsLoading + " seconds , OK, " + DateTime.now().toString("MM/dd/yyyy HH:mm");
                SaveNewData(data);
                LoadNextActivity();
            }
        });
        goodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                String data = "Loading Screen time: " + timeInSecondsLoading + " seconds , GOOD, " + DateTime.now().toString("MM/dd/yyyy HH:mm");
                SaveNewData(data);
                LoadNextActivity();
            }
        });
    }

    void SaveNewData(String data){
        List<String> stringsList = SavingData.getData(getApplicationContext());
        if(stringsList != null)
            stringsList.add(data);
        else
        {
            stringsList = new ArrayList<String>();
            stringsList.add(data);
        }
        SavingData.PushListData(getApplicationContext(), stringsList);
    }

    void LoadNextActivity(){
        Intent i = new Intent(LoadingAnswersActivity.this,
                TextUpdateActivity.class);
        startActivity(i);
        finish();
    }
}
