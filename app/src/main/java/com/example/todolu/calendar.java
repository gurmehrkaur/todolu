package com.example.todolu;
import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class calendar extends AppCompatActivity{

    // Define the variable of CalendarView type
    // and TextView type;
    CalendarView cal;
    TextView date_view;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        button =(Button) findViewById(R.id.create);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                opencreate();
            }
        });

        // By ID we can use each component
        // which id is assign in xml file
        // use findViewById() to get the
        // CalendarView and TextView
        cal = (CalendarView)
                findViewById(R.id.cal);
        date_view = (TextView)
                findViewById(R.id.date_view);

        // Add Listener in calendar
        cal
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0
                                String Date
                                        = (month + 1) + "-"
                                        + dayOfMonth + "-" + year;

                                // set this date in TextView for Display
                                date_view.setText(Date);
                            }
                        });

    }
    public void opencreate(){
        Intent intent = new Intent(this,createevent.class);
        startActivity(intent);
    }

}