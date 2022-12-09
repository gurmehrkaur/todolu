package com.example.todolu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.todolu.R;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;


import java.util.HashMap;
import java.util.UUID;

import Model.User;

public class editprofile extends AppCompatActivity
{
    ImageView editprofilepic, close;
    TextView changepfp, email;
    Button save;
    EditText firstname, lastname;

    FirebaseUser firebaseUser;

    private Uri imageUri;
    private StorageTask uploadTask;
    private StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);

        editprofilepic = findViewById(R.id.editpfp);
        save = findViewById(R.id.save);
        changepfp = findViewById(R.id.changepfptxt);
        firstname = findViewById(R.id.editfirstname);
        lastname = findViewById(R.id.editlastname);
        email = findViewById(R.id.editemail);
        close = findViewById(R.id.close);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        storageRef = FirebaseStorage.getInstance().getReference("Users/imageurl");


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("/Users").child(firebaseUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                firstname.setText(user.getFirstname());
                lastname.setText(user.getLastname());
                email.setText(user.getEmail());

                if(user.getImageurl() != null)
                {
                    Glide.with(getApplicationContext()).load(user.getImageurl()).into(editprofilepic);
                }
                else
                {
                    Toast.makeText(editprofile.this, "ooga booga", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        changepfp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });
        editprofilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProfile(firstname.getText().toString(),
                        lastname.getText().toString(),
                        email.getText().toString());
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void updateProfile(String firstname, String lastname, String email){

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("/Users").child(firebaseUser.getUid());

        HashMap<String, Object> map = new HashMap<>();
        map.put("firstname", firstname);
        map.put("lastname", lastname);
        map.put("email", email);

        reference.updateChildren(map);

        Toast.makeText(editprofile.this, "Successfully updated!", Toast.LENGTH_SHORT).show();
    }
    private String getFileExtension(Uri uri)
    {
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }
    private void uploadImage()
    {
        if(imageUri != null)
        {
            StorageReference fileRef = storageRef.child(System.currentTimeMillis() + "." + getFileExtension(imageUri));
            uploadTask = fileRef.putFile(imageUri);
            uploadTask.continueWithTask(new Continuation() {
                @Override
                public Object then(@NonNull Task task) throws Exception {
                    if (!task.isSuccessful())
                    {
                        throw task.getException();
                    }
                        return fileRef.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                @Override
                public void onComplete(@NonNull Task<Uri> task) {
                    if (task.isSuccessful())
                    {
                        Uri downloadUri = task.getResult();
                        String myUrl = downloadUri.toString();

                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("/Users").child(firebaseUser.getUid());

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("imageurl", ""+myUrl);
                        reference.updateChildren(hashMap);
                    }
                    else
                    {
                        Toast.makeText(editprofile.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(editprofile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            Toast.makeText(this, "No image selected", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null)
        {
            imageUri = data.getData();
            editprofilepic.setImageURI(imageUri);
            uploadImage();
        }
        else
        {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }
    }
}

