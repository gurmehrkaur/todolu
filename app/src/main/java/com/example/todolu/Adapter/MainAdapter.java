package com.example.todolu.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.todolu.R;
import com.example.todolu.model.MainModel;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private List<MainModel> list;
    Context context;

    public MainAdapter(List<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_items, parent, false);

        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        holder.userNameTv.setText(list.get(position).getUserName());
        holder.timeTv.setText(list.get(position).getTimestamp());

        int count = list.get(position).getLikeCount();
        if(count == 0){
            holder.likeCountTv.setVisibility(View.INVISIBLE);
        }else if(count == 1){
            holder.likeCountTv.setText(count + " like");
        }else{
            holder.likeCountTv.setText(count + " like");
        }

        Random random = new Random();

        int color = Color.argb(255, random.nextInt(256), random.nextInt(256),random.nextInt(256))
        Glide.with(context.getApplicationContext())
                .load(list.get(position).getProfileImage())
                .placeholder(R.drawable.ic_person)
                .timeout(6500)
                .into(holder.profileImage);
        Glide.with(context.getApplicationContext())
                .load(list.get(position).getProfileImage())
                .placeholder(new ColorDrawable())
                .timeout(7000)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MainHolder extends RecyclerView.ViewHolder{

        private CircleImageView profileImage;
        private TextView userNameTv, timeTv, likeCountTv;
        private ImageView imageView;
        private ImageButton likeBtn;
        public MainHolder(@NonNull View itemView) {
            super(itemView);

            profileImage = imageView.findViewById(R.id.profileImage);
            imageView = imageView.findViewById(R.id.imageView);
            userNameTv = imageView.findViewById(R.id.nameTv);
            timeTv = imageView.findViewById(R.id.timeTv);
            likeCountTv = imageView.findViewById(R.id.likeCountTv);
            likeBtn = imageView.findViewById(R.id.likeBtn);
        }
    }
}
