package com.example.todolu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.ProgressBar;
import android.widget.Toast;


public class login extends AppCompatActivity implements View.OnClickListener{
    private TextView noaccount;
    private EditText editpassword,editusername;
    private Button login;
    private FirebaseAuth mAuth;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        noaccount = (TextView) findViewById(R.id.noaccount);
        noaccount.setOnClickListener(this);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        editusername = (EditText) findViewById(R.id.username);
        editpassword = (EditText) findViewById(R.id.password);
        progressbar = (ProgressBar) findViewById(R.id.loading);
        mAuth = FirebaseAuth.getInstance();

    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.noaccount:
                startActivity(new Intent(this,registration.class));
                break;
            case R.id.login:
                userlogin();
                break;
        }
    }
    private void userlogin(){
        String email = editusername.getText().toString().trim();
        String pw = editpassword.getText().toString().trim();

        if(email.isEmpty()){
            editusername.setError("Username required");
            editusername.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editusername.setError("Please enter valid username");
            editusername.requestFocus();
            return;
        }
        if(pw.isEmpty()){
            editpassword.setError("Password is required");
            editpassword.requestFocus();
            return;
        }
        if(pw.length() < 6){
            editpassword.setError("Min password length is 6 characters");
            editpassword.requestFocus();
            return;
        }
        progressbar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    // redirect to home page
                    startActivity(new Intent(login.this,home.class));
                }
                else{
                    Toast.makeText(login.this,"Wrong Username or Password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}