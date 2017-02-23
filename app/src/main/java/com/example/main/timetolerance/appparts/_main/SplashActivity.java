package com.example.main.timetolerance.appparts._main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.main.timetolerance.R;

import java.util.Random;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                int timeInSeconds = 0;
                try {
                    super.run();
                    int seconds = (new Random().nextInt(5)) + 1;
                    Log.d("TIME DELAY: ", "" + seconds);
                    timeInSeconds = seconds;
                    Log.d("FINAL DELAY: ", "" + (long)(seconds * 1000));
                    sleep((long)(seconds * 1000));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    Intent i = new Intent(SplashActivity.this,
                            MainActivity.class);
                    i.putExtra("timeInSeconds", timeInSeconds);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
