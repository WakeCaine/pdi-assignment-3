package com.example.main.timetolerance;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
                try {
                    super.run();
                    float seconds = (new Random().nextInt(5)) + 1;
                    Log.d("TIME DELAY: ", "" + seconds);
                    Log.d("FINAL DELAY: ", "" + (long)(seconds * 1000));
                    sleep((long)(seconds * 1000));
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(LoadingActivity.this,
                            LoadingAnswersActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }

}
