package com.example.main.timetolerance.appparts.loading;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.main.timetolerance.DataListActivity;
import com.example.main.timetolerance.R;

import java.util.Random;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoadingActivity.this,
                        DataListActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button loadingStart = (Button) findViewById(R.id.loadingButton);
        loadingStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.loading_results);
                LoadNewActivity();
            }
        });
    }

    void LoadNewActivity(){
        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                int time = 0;
                try {
                    super.run();
                    int seconds = (new Random().nextInt(5)) + 1;
                    time = seconds;
                    Log.d("TIME DELAY: ", "" + seconds);
                    Log.d("FINAL DELAY: ", "" + (long)(seconds * 1000));
                    sleep((long)(seconds * 1000));
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(LoadingActivity.this,
                            LoadingAnswersActivity.class);
                    i.putExtra("timeInSeconds", time);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }

}
