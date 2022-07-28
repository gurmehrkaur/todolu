package com.example.todolu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class todo extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button noaccount = findViewById(R.id.noaccount);
        noaccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                changetoregister();
            }
        });
    }

    private void changetoregister()
    {
        Intent intent = new Intent(todo.this, registration.class);
        startActivity(intent);
    }

}