package com.example.todolu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

import Model.User;

public class profile extends AppCompatActivity {

    private ImageView pfp, profiledisplay;
    public Uri imageUri;
    private FirebaseStorage storage;
    private FirebaseUser firebaseUser;
    private StorageReference storageRef;
    TextView firstname, fullname;
    private Button editprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        pfp = findViewById(R.id.pfpprofile);
        firstname = findViewById(R.id.firstnamepfp);
        fullname = findViewById(R.id.fullnamepfp);
        editprofile = findViewById(R.id.editprofilepfp);

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changetoeditprofile();
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
                fullname.setText(user.getFirstname() + " " + user.getLastname());
                if(user.getImageurl() != null)
                {
                    Glide.with(getApplicationContext()).load(user.getImageurl()).into(pfp);
                }
                else
                {
                    Toast.makeText(profile.this, "ooga booga", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }
    private void changetoeditprofile() {
        Intent changetoeditprofile = new Intent(this, editprofile.class);
        startActivity(changetoeditprofile);
    }
}