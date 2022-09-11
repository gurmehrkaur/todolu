package com.example.todolu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class music extends AppCompatActivity
{
    ImageButton getrainbtn, getwavesbtn, getcafebtn, getforestbtn, getpausebtn, getplaybtn;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);

        //sound library sounds
        getrainbtn = findViewById(R.id.rainbtn);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.rain_audio);
        getrainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        getwavesbtn = findViewById(R.id.wavesbtn);
        MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.waves_audio);
        getwavesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer1.start();
            }
        });
        getcafebtn = findViewById(R.id.cafebtn);
        MediaPlayer mediaPlayer2 = MediaPlayer.create(this, R.raw.cafe_audio);
        getcafebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.start();
            }
        });
        getforestbtn = findViewById(R.id.forestbtn);
        MediaPlayer mediaPlayer3 = MediaPlayer.create(this, R.raw.forest_audio);
        getforestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.start();
            }
        });
        getplaybtn = findViewById(R.id.playbtn);
        getplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        //pause button
        getpausebtn = findViewById(R.id.pausebtn);
        getpausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                mediaPlayer1.stop();
                mediaPlayer2.stop();
                mediaPlayer3.stop();
            }
        });
        }
    }
