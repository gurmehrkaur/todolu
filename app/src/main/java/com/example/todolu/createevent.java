package com.example.todolu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class createevent extends AppCompatActivity {
    EditText title;
    EditText location;
    EditText description;
    Button addevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createevent);

        title = findViewById(R.id.eventtitle);
        location = findViewById(R.id.location);
        description = findViewById(R.id.description);
        addevent = findViewById(R.id.createevent);

        addevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!title.getText().toString().isEmpty() && !location.getText().toString().isEmpty()
                        && !description.getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    intent.setData(CalendarContract.Events.CONTENT_URI);
                    intent.putExtra(CalendarContract.Events.TITLE,title.getText().toString());
                    intent.putExtra(CalendarContract.Events.EVENT_LOCATION,location.getText().toString());
                    intent.putExtra(CalendarContract.Events.DESCRIPTION,description.getText().toString());
                    intent.putExtra(CalendarContract.Events.ALL_DAY,true);
                    if(intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    } else{
                        Toast.makeText(createevent.this, "There is no app that can support this action", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(createevent.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
