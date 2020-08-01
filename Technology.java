package com.example.thinkerlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Technology extends AppCompatActivity {
    List<TechnologyStart> list;
    ImageView back;
    private TechnologyAdapter.RecyclerViewClickListener listener;
//TextView b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_technology);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Technology.this,HomePage.class));
            }
        });
       // b=findViewById(R.id.textView10);
        list=new ArrayList<>();
        list.add(new TechnologyStart("Basics of Python","Category","Description",R.drawable.python));
        list.add(new TechnologyStart("Fundamentals of C","Category","Description",R.drawable.cprog));
        list.add(new TechnologyStart("Fundamentals of C++","Category","Description",R.drawable.cpp));
        list.add(new TechnologyStart("Data Structures and Algorithms","Category","Description",R.drawable.dsa));
        list.add(new TechnologyStart("Electronics For Kids","Category","Description",R.drawable.electronics));
        list.add(new TechnologyStart("Robotics For Kids","Category","Description",R.drawable.robotics));
        list.add(new TechnologyStart("Basics of Arduino","Category","Description",R.drawable.ardeuino));
        list.add(new TechnologyStart("Artificial Intelligence for Beginners","Category","Description",R.drawable.ai));
        list.add(new TechnologyStart("Raspberry Pi for Beginners","Category","Description",R.drawable.rasp));
        list.add(new TechnologyStart("Rocketry","Category","Description",R.drawable.rock));
        list.add(new TechnologyStart("Web Development(HTML+CSS)","Category","Description",R.drawable.webd_html));
        list.add(new TechnologyStart("Web Development(ASP.NET)","Category","Description",R.drawable.asp));
        list.add(new TechnologyStart("Scratch","Category","Description",R.drawable.scratch));
        list.add(new TechnologyStart("Blockchain","Category","Description",R.drawable.blk));
        list.add(new TechnologyStart("JAVA","Category","Description",R.drawable.java));
        list.add(new TechnologyStart("Javascript","Category","Description",R.drawable.jvs));
        list.add(new TechnologyStart("Internet Of Things","Category","Description",R.drawable.iot));
        list.add(new TechnologyStart("Game Development using PyGame","Category","Description",R.drawable.pygame));
        setOnClickListener();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview1);
        TechnologyAdapter adapter=new TechnologyAdapter(this,list,listener);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(adapter);
    }
    private void setOnClickListener() {
        listener = new TechnologyAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {

                Intent intent = new Intent(getApplicationContext(), BasicsPython.class);
                startActivity(intent);
            }


        };
    }
}
