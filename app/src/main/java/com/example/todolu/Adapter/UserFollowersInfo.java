package com.example.todolu.Adapter;


import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.todolu.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;

import Model.User;
import de.hdodenhof.circleimageview.CircleImageView;


public class UserFollowersInfo extends RecyclerView.Adapter<UserFollowersInfo.ViewHolder>
{
    private Context currentcontext;
    private List<User> mUsers;

    private FirebaseUser firebaseUser;


    public UserFollowersInfo(Context currentcontext, List<User> mUsers, boolean b) {
        this.currentcontext = currentcontext;
        this.mUsers = mUsers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(currentcontext).inflate(R.layout.user_item, parent, false);
        return new UserFollowersInfo.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        final User user = mUsers.get(position);

        holder.btn_follow.setVisibility(View.VISIBLE);
        isFollowing(user.getId(), holder.btn_follow);

        holder.email.setText(user.getEmail());
        holder.firstname.setText(user.getFirstname());
        Glide.with(currentcontext).load(user.getImageurl()).into(holder.pfp);

        //if user is on their profile, follow btn will not appear
        //following btn visibility
        if (user.getId().equals(firebaseUser.getUid())){
            holder.btn_follow.setVisibility(View.GONE);
        }

        holder.btn_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.btn_follow.getText().toString().equals("follow"))
                {
                    //follower and followee will get added under followers in database
                    FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid())
                            .child("following").child(user.getId()).setValue(true);
                    FirebaseDatabase.getInstance().getReference("Users").child(user.getId())
                            .child("followers").child(firebaseUser.getUid()).setValue(true);
                    addNotification(user.getId());
                }
                else //unfollow - removing following and follower
                {
                    FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid())
                            .child("following").child(user.getId()).removeValue();
                    FirebaseDatabase.getInstance().getReference("Users").child(user.getId())
                            .child("followers").child(firebaseUser.getUid()).removeValue();
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = currentcontext.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();
                editor.putString("profileid", user.getId());
                editor.apply();
            }
        });
    }

    private void addNotification(String userid)
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Notifications").child(userid);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userid", firebaseUser.getUid());
        hashMap.put("text", "started following you");

        reference.push().setValue(hashMap);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView email;
        public TextView firstname;
        public CircleImageView pfp;
        public Button btn_follow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.emailitem);
            firstname = itemView.findViewById(R.id.firstnameitem);
            pfp = itemView.findViewById(R.id.userpfp);
            btn_follow = itemView.findViewById(R.id.follow);
        }
    }
    private void isFollowing(final String userid, final Button button){

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users")
                .child(firebaseUser.getUid()).child("following");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(userid).exists()){
                    button.setText("following");
                } else{
                    button.setText("follow");
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}