package com.example.todolu.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.todolu.fragments.Add;
import com.example.todolu.fragments.AddBlogsFragment;
import com.example.todolu.fragments.Home;
import com.example.todolu.fragments.Notification;
import com.example.todolu.fragments.Profile;
import com.example.todolu.fragments.searchuserfrag;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int noOfTabs;

    public ViewPagerAdapter(@NonNull FragmentManager fragmentActivity, int noOfTabs) {
        super(fragmentActivity);
        this.noOfTabs = noOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Home();
            case 1:
                return new searchuserfrag();
            case 2:
                return new AddBlogsFragment();
            case 3:
                return new Notification();
            case 4:
                return new Profile();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
