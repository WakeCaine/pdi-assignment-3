package com.example.main.timetolerance.appparts.textupdate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.main.timetolerance.DataListActivity;
import com.example.main.timetolerance.FinalActivity;
import com.example.main.timetolerance.R;
import com.example.main.timetolerance.data.SavingData;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TextUpdateActivity extends AppCompatActivity {
    TextView resultText, numberText;
    Button badButton, okButton, goodButton, resultButton;
    float timeInSeconds;

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
                Intent i = new Intent(TextUpdateActivity.this,
                        DataListActivity.class);
                startActivity(i);
                finish();
            }
        });

        resultText = (TextView) findViewById(R.id.resultTextView);
        numberText = (TextView) findViewById(R.id.numberTextView);

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
                        float time = 0;
                        try {
                            super.run();
                            int seconds = new Random().nextInt(9);
                            float values[] = {0.4f, 0.6f, 0.8f, 1.0f, 1.2f, 1.4f, 1.6f, 1.8f, 2f};
                            Log.d("TIME DELAY: ", "" + values[seconds]);
                            time = values[seconds];
                            Log.d("FINAL DELAY: ", "" + (long)(time * 1000));
                            sleep((long)(time * 1000));
                        } catch (Exception e) {

                        } finally {
                            final float timer = time;
                            handler.post(new Runnable(){
                                public void run() {
                                    updateText(timer);
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
                String data = "TextUpdate Screen time: " + timeInSeconds + " seconds , BAD, " + DateTime.now().toString("MM/dd/yyyy HH:mm");
                SaveNewData(data);
                LoadNextActivity();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                String data = "TextUpdate Screen time: " + timeInSeconds + " seconds , OK, " + DateTime.now().toString("MM/dd/yyyy HH:mm");
                SaveNewData(data);
                LoadNextActivity();
            }
        });
        goodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Results saved.", Toast.LENGTH_SHORT).show();
                //save data here
                String data = "TextUpdate Screen time: " + timeInSeconds + " seconds , GOOD, " + DateTime.now().toString("MM/dd/yyyy HH:mm");
                SaveNewData(data);
                LoadNextActivity();
            }
        });

    }
    void updateText(float time){
        timeInSeconds = time;
        resultText.setText("How do you rate speed of value update?");
        numberText.setText("4");
        numberText.setTextSize(60);
        resultButton.setVisibility(View.INVISIBLE);
        badButton.setVisibility(View.VISIBLE);
        numberText.setVisibility(View.VISIBLE);
        okButton.setVisibility(View.VISIBLE);
        goodButton.setVisibility(View.VISIBLE);
    }

    void LoadNextActivity(){
        Intent i = new Intent(TextUpdateActivity.this,
                FinalActivity.class);
        startActivity(i);
        finish();
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
}
