package com.example.thinkerlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

public class BuildingWithBricks extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_building_with_bricks);
            toolbar=(Toolbar)findViewById(R.id.toolbarmath5);
            tabLayout=findViewById(R.id.TabLayout);
            viewPager=findViewById(R.id.ViewPager1);
            setSupportActionBar(toolbar);
            setupViewPager(viewPager);
            tabLayout.setupWithViewPager(viewPager);



        }


        private void setupViewPager(ViewPager viewPager)
        {
            ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
            viewPagerAdapter.addFragment(new ALLFragment(),"ALL");
            viewPagerAdapter.addFragment(new TestsFragment(),"Tests");
            viewPagerAdapter.addFragment(new DocsFragment(),"Docs");
            viewPagerAdapter.addFragment(new VideosFragment(),"Videos");
            viewPager.setAdapter(viewPagerAdapter);


        }

    }

