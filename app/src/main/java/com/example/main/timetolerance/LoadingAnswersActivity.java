package com.example.main.timetolerance;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoadingAnswersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_answers);
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

        Button badButton = (Button) findViewById(R.id.badButton);
        Button okButton = (Button) findViewById(R.id.okButton);
        Button goodButton = (Button) findViewById(R.id.goodButton);
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
    void LoadNextActivity(){
        Intent i = new Intent(LoadingAnswersActivity.this,
                TextUpdateActivity.class);
        startActivity(i);
        finish();
    }
}
