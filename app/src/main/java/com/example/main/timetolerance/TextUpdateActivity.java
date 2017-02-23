package com.example.main.timetolerance;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TextUpdateActivity extends AppCompatActivity {
    TextView resultText;
    Button badButton, okButton, goodButton, resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_update);
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

        resultText = (TextView) findViewById(R.id.resultTextView);

        badButton = (Button) findViewById(R.id.badButton);
        okButton = (Button) findViewById(R.id.okButton);
        goodButton = (Button) findViewById(R.id.goodButton);
        resultButton = (Button) findViewById(R.id.buttonResult);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler();
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
                            handler.post(new Runnable(){
                                public void run() {
                                    updateText();
                                }
                            });
                        }
                    }
                };
                welcomeThread.start();
            }
        });
        badButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                LoadNextActivity();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                LoadNextActivity();
            }
        });
        goodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                LoadNextActivity();
            }
        });

    }
    void updateText(){
        resultText.setText("4\nHow do you rate speed of value update?");
        resultButton.setVisibility(View.INVISIBLE);
        badButton.setVisibility(View.VISIBLE);
        okButton.setVisibility(View.VISIBLE);
        goodButton.setVisibility(View.VISIBLE);
    }

    void LoadNextActivity(){
        Intent i = new Intent(TextUpdateActivity.this,
                FinalActivity.class);
        startActivity(i);
        finish();
    }
}
