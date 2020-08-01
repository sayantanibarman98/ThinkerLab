package com.example.thinkerlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BasicsPython extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private FrameLayout frameLayout;
    private BPC bpc;
    private BPI bpi;
    private BPL bpl;
    private BPO bpo;
    private BPR bpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics_python);
        frameLayout=(FrameLayout)findViewById(R.id.nav_FrameLayout);
        navigationView=(BottomNavigationView)findViewById(R.id.main_nav);
        bpc=new BPC();
        bpi=new BPI();
        bpl=new BPL();
        bpo=new BPO();
        bpr=new BPR();
        setFragment(bpo);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_overview:
                        setFragment(bpo);
                        return true;
                    case R.id.nav_curriculum:
                        setFragment(bpc);
                        return true;
                    case R.id.nav_instructor:
                        setFragment(bpi);
                        return true;
                    case R.id.nav_lectures:
                        setFragment(bpl);
                        return true;
                    case R.id.nav_review:
                        setFragment(bpr);
                       // navigationView.setItemBackgroundResource(R.color.colorAccent);
                        return true;
                    default:
                        return false;
                }
            }


        });
    }
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nav_FrameLayout,fragment);
        fragmentTransaction.commit();

    }
}
