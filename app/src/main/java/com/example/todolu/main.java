package com.example.todolu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.fragment.app.FragmentTransaction;

import com.example.todolu.fragments.Home;


import com.example.todolu.Adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class main extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    ViewPagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        init();

        addTabs();
        Home fragment = new Home();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewPager, fragment, "");
        fragmentTransaction.commit();
    }

    private void init(){

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

    }

    private void addTabs(){

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_house));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_search));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_add));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_profile));

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house);
                        break;
                    case 1:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_search);
                        break;
                    case 2:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_add);
                        break;
                    case 3:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_profile);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                switch (tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house);
                        break;
                    case 1:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_search);
                        break;
                    case 2:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_add);
                        break;
                    case 3:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_profile);
                        break;
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                switch (tab.getPosition()){
                    case 0:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_house);
                        break;
                    case 1:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_search);
                        break;
                    case 2:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_add);
                        break;
                    case 3:
                        tabLayout.getTabAt(0).setIcon(R.drawable.ic_profile);
                        break;
                }

            }
        });
    }
}
