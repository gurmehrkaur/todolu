package com.example.todolu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class music extends AppCompatActivity
{
    ImageButton getrainbtn, getwavesbtn, getcafebtn, getforestbtn, getpausebtn, getplaybtn, getstopbtn, getspotifybtn, getyoutbtn;
    Boolean isPlaying = false;
    String[] songs = {"rain", "waves", "cafe", "forest"};
    ArrayList<String> nowplaying = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);

        //sound library sounds
        getrainbtn = findViewById(R.id.rainbtn);
        MediaPlayer raintrack = MediaPlayer.create(this, R.raw.rain_audio);
        getrainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                raintrack.start();
                isPlaying = true;
                nowplaying.add(songs[0]);
            }
        });
        getwavesbtn = findViewById(R.id.wavesbtn);
        MediaPlayer wavestrack = MediaPlayer.create(this, R.raw.waves_audio);
        getwavesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wavestrack.start();
                isPlaying = true;
                nowplaying.add(songs[1]);;
            }
        });
        getcafebtn = findViewById(R.id.cafebtn);
        MediaPlayer cafetrack = MediaPlayer.create(this, R.raw.cafe_audio);
        getcafebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cafetrack.start();
                isPlaying = true;
                nowplaying.add(songs[2]);
            }
        });
        getforestbtn = findViewById(R.id.forestbtn);
        MediaPlayer foresttrack = MediaPlayer.create(this, R.raw.forest_audio);
        getforestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foresttrack.start();
                isPlaying = true;
                nowplaying.add(songs[3]);
            }
        });
        getplaybtn = findViewById(R.id.playbtn);
        getplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying == false) //if nothing is playing, check arraylist to see what is clicked
                {
                    if (nowplaying.contains("rain"))
                    {
                        raintrack.start();
                        isPlaying = true;
                    }
                    if (nowplaying.contains("waves"))
                    {
                        wavestrack.start();
                        isPlaying = true;
                    }
                    if (nowplaying.contains("cafe"))
                    {
                        cafetrack.start();
                        isPlaying = true;
                    }
                    if (nowplaying.contains("forest"))
                    {
                        foresttrack.start();
                        isPlaying = true;
                    }
                    else if (nowplaying.isEmpty())
                    {
                    }
                }
                else if (isPlaying == true)
                {
                    Toast toast = Toast.makeText(music.this, "Music is already playing.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        //pause button
        getpausebtn = findViewById(R.id.pausebtn);
        getpausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when pause is clicked, check arraylist to see what is playing to pause the audio
                if (isPlaying == true)
                {
                    if (nowplaying.contains("rain"))
                    {
                        raintrack.pause();
                        isPlaying = false;
                    }
                    if (nowplaying.contains("waves"))
                    {
                        wavestrack.pause();
                        isPlaying = false;
                    }
                    if (nowplaying.contains("cafe"))
                    {
                        cafetrack.pause();
                        isPlaying = false;
                    }
                    if (nowplaying.contains("forest"))
                    {
                        foresttrack.pause();
                        isPlaying = false;
                    }
                }
                else if (!isPlaying) //notification for when pause is clicked but nothing is playing
                {
                    Toast toast = Toast.makeText(music.this, "Nothing is currently playing.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        getstopbtn = findViewById(R.id.stopbtn);
        getstopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(isPlaying == true) {
                    raintrack.pause();
                    wavestrack.pause();
                    cafetrack.pause();
                    wavestrack.pause();
                    foresttrack.pause();
                    raintrack.seekTo(0);
                    wavestrack.seekTo(0);
                    cafetrack.seekTo(0);
                    foresttrack.seekTo(0);
                    nowplaying.removeAll(nowplaying);
                    isPlaying = false;
                }
                else if (!isPlaying && nowplaying.isEmpty())
                {
                    Toast toast = Toast.makeText(music.this, "Nothing has been chosen or stop has cleared it.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

    private void changetohome() {
        Intent changetohomepg = new Intent(this, home.class);
        startActivity(changetohomepg);
    }
}