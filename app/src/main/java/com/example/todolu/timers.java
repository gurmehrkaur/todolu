package com.example.todolu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class timers extends AppCompatActivity {

    private int seconds;
    private boolean running;
    private boolean wasRunning;

    public static long START_TIME_IN_MILLIS = 600000;
    CountDownTimer countDownTimer;
    public long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    public int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timers);

        if(savedInstanceState != null){
            savedInstanceState.getInt("seconds");
            savedInstanceState.getBoolean("running");
            savedInstanceState.getBoolean("wasRunning");

        }

        startTimer();
        runTimer();
    }


    public void onTimerStart(View view) {countDownTimer.start();}
    public void onTimerStop(View view) {countDownTimer.cancel();}
    public void onTimerReset(View view) {
        countDownTimer.onFinish();
    }


    public void onStart(View view){running = true;}
    public void onStop(View view){
        running = false;
    }
    public void onReset(View view){
        running = false;
        seconds = 0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);
    }

    private void runTimer() {

        TextView timeView = findViewById(R.id.textView);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d",
                        hours, minutes, secs);
                timeView.setText(time);

                if(running){
                    seconds++;
                }

                handler.postDelayed( this, 1000);


            }
        });
    }


    private void startTimer(){

        TextView timerView = findViewById(R.id.timerView);

            countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTimeLeftInMillis = millisUntilFinished;
                            int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
                            int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

                            String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                            timerView.setText((timeLeftFormatted));
                        }
                    });
                }

                @Override
                public void onFinish() {
                    if(count == 0) {
                        mTimeLeftInMillis = 600000;
                        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
                        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

                        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                        timerView.setText((timeLeftFormatted));
                        count++;
                    }else{
                        mTimeLeftInMillis = 300000;
                        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
                        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

                        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                        timerView.setText((timeLeftFormatted));
                        count = 0;
                    }
                }

            }.start();

    }


}