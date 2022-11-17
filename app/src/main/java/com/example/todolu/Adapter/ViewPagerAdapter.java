package com.example.todolu.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.todolu.fragments.Add;
import com.example.todolu.fragments.Home;
import com.example.todolu.fragments.Notification;
import com.example.todolu.fragments.Profile;
import com.example.todolu.fragments.Search;

public class ViewPagerAdapter extends FragmentStateAdapter {

    int noOfTabs;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int noOfTabs) {
        super(fm);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new Home();
            case 1:
                return new Search();
            case 2:
                return new Add();
            case 3:
                return new Notification();
            case 4:
                return new Profile();
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return noOfTabs;
    }
}
