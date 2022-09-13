package com.example.todolu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class music extends AppCompatActivity
{
    private ImageButton getrainbtn, getwavesbtn, getcafebtn, getforestbtn, getpausebtn, getplaybtn, getstopbtn, getspotifybtn, getyoutbtn;
    private Boolean isPlaying = false;
    private String[] songs = {"rain", "waves", "cafe", "forest"};
    private ArrayList<String> nowplaying = new ArrayList<String>();
    private MediaPlayer playsound;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);
        //sound library sounds
        getrainbtn = findViewById(R.id.rainbtn);
        getrainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playsound = MediaPlayer.create(music.this, R.raw.rain_audio);
                playsound.start();
                isPlaying = true;
                nowplaying.add(songs[0]);
            }
        });
        getwavesbtn = findViewById(R.id.wavesbtn);
        getwavesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playsound = MediaPlayer.create(music.this, R.raw.waves_audio);
                playsound.start();
                isPlaying = true;
                nowplaying.add(songs[1]);;
            }
        });
        getcafebtn = findViewById(R.id.cafebtn);
        getcafebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playsound = MediaPlayer.create(music.this, R.raw.cafe_audio);
                playsound.start();
                isPlaying = true;
                nowplaying.add(songs[2]);
            }
        });
        getforestbtn = findViewById(R.id.forestbtn);
        getforestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playsound = MediaPlayer.create(music.this, R.raw.forest_audio);
                playsound.start();
                isPlaying = true;
                nowplaying.add(songs[3]);
            }
        });
        getplaybtn = findViewById(R.id.playbtn);
        getplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying == false && !nowplaying.isEmpty()) //if nothing is playing, check arraylist to see what is clicked
                {
                  playsound.start();
                  isPlaying = true;
                }
                else if (isPlaying == false && nowplaying.isEmpty())
                {
                    Toast toast = Toast.makeText(music.this, "Nothing has been selected to play or stop has cleared it.", Toast.LENGTH_LONG);
                    toast.show();
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
                    playsound.pause();
                    isPlaying = false;
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
                if(playsound != null) {
                    playsound.stop();
                    playsound.release();
                    playsound = null;
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
    }
