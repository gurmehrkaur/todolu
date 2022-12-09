package com.example.todolu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.todolu.Adapter.UserFollowersInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Model.User;

public class followers extends AppCompatActivity {

    String id, location;
    List<String> idnumbers;
    RecyclerView recyclerView;
    UserFollowersInfo followerinfo;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userList = new ArrayList<>();
        followerinfo = new UserFollowersInfo(this, userList, false);
        recyclerView.setAdapter(followerinfo);

        idnumbers = new ArrayList<>();

        switch (location) {
            case "following":
                getFollowing();
                break;
            case "followers":
                getFollowers();
                break;
        }
    }

    private void getFollowers() {
        DatabaseReference reference =  FirebaseDatabase.getInstance().getReference("Users").child(id)
                .child("followers");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                idnumbers.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    idnumbers.add(snapshot.getKey());
                }
                showUsers();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void getFollowing() {
        DatabaseReference reference =  FirebaseDatabase.getInstance().getReference("Users").child(id)
                .child("following");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                idnumbers.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    idnumbers.add(snapshot.getKey());
                }
                showUsers();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showUsers() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("/Users");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    for (String id : idnumbers){
                        if (user.getId().equals(id)){
                            userList.add(user);
                        }
                    }
                }
                followerinfo.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
