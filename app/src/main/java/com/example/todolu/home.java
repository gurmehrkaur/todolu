package com.example.todolu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import Model.User;

public class home extends AppCompatActivity {

    private ImageButton post;
    private ImageView pfp;
    private Button search;
    public Uri imageUri;
    private FirebaseStorage storage;
    private StorageReference storageRef;
    FirebaseUser firebaseUser;
    TextView firstname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        post = findViewById(R.id.postbtn);
        pfp = findViewById(R.id.pfphome);
        firstname = findViewById(R.id.firstnamehome);
        search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changetosearch();
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changetomakepost();
            }
        });
        pfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changetoprofile();
            }
        });


        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        storageRef = FirebaseStorage.getInstance().getReference("Users/imageurl");
        //load user information
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                firstname.setText(user.getFirstname());
                if(user.getImageurl() != null)
                {
                    Glide.with(getApplicationContext()).load(user.getImageurl()).into(pfp);
                }
                else
                {
                    Toast.makeText(home.this, "ooga booga", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }
    private void changetomakepost() {
        Intent changetopost = new Intent(this, makepost.class);
        startActivity(changetopost);
    }
    private void changetoprofile() {
        Intent changetoprofile = new Intent(this, profile.class);
        startActivity(changetoprofile);
    }
    private void changetosearch(){
        Fragment fragment = new searchuserfrag();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment).commit();
    }
}