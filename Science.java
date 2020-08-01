package com.example.thinkerlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Science extends AppCompatActivity {
//TextView d;
    ImageView back;
CardView cls4,cls5,cls6,cls7,cls8,cls9,cls10,cls11,cls12,wbj,jee,olymp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_science);

        cls4=findViewById(R.id.CardViewClass4);
        cls5=findViewById(R.id.CardViewClass5);
        cls6=findViewById(R.id.CardViewClass6);
        cls7=findViewById(R.id.CardViewClass7);
        cls8=findViewById(R.id.CardViewClass8);
        cls9=findViewById(R.id.CardViewClass9);
        cls10=findViewById(R.id.CardViewClass10);
        cls11=findViewById(R.id.CardViewClass11);
        cls12=findViewById(R.id.CardViewClass12);
        wbj=findViewById(R.id.CardViewWBJEE);
        jee=findViewById(R.id.CardViewJEE);
        olymp=findViewById(R.id.CardViewOlympiad);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Science.this,HomePage.class));
            }
        });
        cls4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, Engineering.class);
                startActivity(i);
            }
        });
        cls5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, Engineering.class);
                startActivity(i);
            }
        });
        cls6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, ScienceClass6.class);
                startActivity(i);
            }
        });
        cls7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, ScienceClass7.class);
                startActivity(i);
            }
        });
        cls8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, ScienceClass8.class);
                startActivity(i);
            }
        });
        cls9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, ScienceClass9.class);
                startActivity(i);
            }
        });
        cls10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, ScienceClass10.class);
                startActivity(i);
            }
        });
        cls11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, ScienceClass11.class);
                startActivity(i);
            }
        });
        cls12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, ScienceClass12.class);
                startActivity(i);
            }
        });
        wbj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, Engineering.class);
                startActivity(i);
            }
        });
        jee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, Engineering.class);
                startActivity(i);
            }
        });
        olymp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Science.this, Engineering.class);
                startActivity(i);
            }
        });




        //d=findViewById(R.id.textView11);
    }
}
