package com.example.thinkerlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Maths extends AppCompatActivity {
    //RecyclerView recyclerView;
   // MyAdapter myAdapter;
    ImageView back;
    CardView cls4,cls5,cls6,cls7,cls8,cls9,cls10,cls11,cls12,wbj,jee,olymp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_maths);
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
                startActivity(new Intent(Maths.this,HomePage.class));
            }
        });
        cls4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, MathsClass4.class);
                startActivity(i);
            }
        });
        cls5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, MathsClass5.class);
                startActivity(i);
            }
        });
        cls6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, MathsClass6.class);
                startActivity(i);
            }
        });
        cls7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, MathsClass7.class);
                startActivity(i);
            }
        });
        cls8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, MathsClass8.class);
                startActivity(i);
            }
        });
        cls9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, MathsClass9.class);
                startActivity(i);
            }
        });
        cls10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, MathsClass10.class);
                startActivity(i);
            }
        });
        cls11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, MathsClass11.class);
                startActivity(i);
            }
        });
        cls12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, MathsClass12.class);
                startActivity(i);
            }
        });
        wbj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, Engineering.class);
                startActivity(i);
            }
        });
        jee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, Engineering.class);
                startActivity(i);
            }
        });
        olymp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Maths.this, Engineering.class);
                startActivity(i);
            }
        });




        //d=findViewById(R.id.textView11);
    }
}

       /* recyclerView=findViewById(R.id.RV2);
        ArrayList<Model> models=new ArrayList<>();
        models.add(new Model("Class IV",R.drawable.class4));
        models.add(new Model("Class V",R.drawable.class4));
        models.add(new Model("Class VI",R.drawable.class4));
        models.add(new Model("Class VII",R.drawable.class4));
        models.add(new Model("Class VIII",R.drawable.class4));
        models.add(new Model("Class IX",R.drawable.class4));
        models.add(new Model("Class X",R.drawable.class4));
        models.add(new Model("Class XI",R.drawable.class4));
        models.add(new Model("Class XII",R.drawable.class4));
        models.add(new Model("WBJEE",R.drawable.class4));
        models.add(new Model("JEE-MAINS",R.drawable.class4));
        models.add(new Model("Olympiad",R.drawable.class4));

        myAdapter=new MyAdapter(this,models);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //mainGrid=(GridLayout)findViewById(R.id.mainGrid);
        //setSingleEvent(mainGrid);
    }
   /* private ArrayList<Model> getMyList()
    {
        ArrayList<Model> models=new ArrayList<>();
        //Class 4
        Model m=new Model();
        m.setName("Class 4");
        m.setImg(R.drawable.class4);
        models.add(m);
        //Class 5
        m=new Model();
        m.setName("Class 5");
        m.setImg(R.drawable.class4);
        models.add(m);
        //Class 6
        m=new Model();
        m.setName("Class 6");
        m.setImg(R.drawable.class4);
        models.add(m);
        //Class 7
        m=new Model();
        m.setName("Class 7");
        m.setImg(R.drawable.class4);
        models.add(m);
        //Class 8
        m=new Model();
        m.setName("Class 4");
        m.setImg(R.drawable.class4);
        models.add(m);
        //Class 9
        m=new Model();
        m.setName("Class 4");
        m.setImg(R.drawable.class4);
        models.add(m);
        //Class 10
        m=new Model();
        m.setName("Class 4");
        m.setImg(R.drawable.class4);
        models.add(m);
        //Class 11
        m=new Model();
        m.setName("Class 4");
        m.setImg(R.drawable.class4);
        models.add(m);
        //Class 12
        m=new Model();
        m.setName("Class 4");
        m.setImg(R.drawable.class4);
        models.add(m);
        //WBJEE
        m=new Model();
        m.setName("Class 4");
        m.setImg(R.drawable.class4);
        models.add(m);
        //JEEMAINS
        m=new Model();
        m.setName("Class 4");
        m.setImg(R.drawable.class4);
        models.add(m);
        //OLympiad
        m=new Model();
        m.setName("Class 4");
        m.setImg(R.drawable.class4);
        models.add(m);
        return models;

    }
   /* private void setSingleEvent(GridLayout mainGrid)
    {
        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            CardView cardView=(CardView)mainGrid.getChildAt(i);
            final int f=i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(f==0)
                    {
                        Intent intent=new Intent(Maths.this,MathsClass4.class);
                        startActivity(intent);
                    }
                    else if(f==1)
                    {
                        Intent intent=new Intent(Maths.this,MathsClass5.class);
                        startActivity(intent);
                    }
                    else if(f==2)
                    {
                        Intent intent=new Intent(Maths.this,MathsClass6.class);
                        startActivity(intent);
                    }
                    else if(f==3)
                    {
                        Intent intent=new Intent(Maths.this,MathsClass7.class);
                        startActivity(intent);
                    }
                    else if(f==4)
                    {
                        Intent intent=new Intent(Maths.this,MathsClass8.class);
                        startActivity(intent);
                    }
                    else if(f==5)
                    {
                        Intent intent=new Intent(Maths.this,MathsClass9.class);
                        startActivity(intent);
                    }
                    else if(f==6)
                    {
                        Intent intent=new Intent(Maths.this,MathsClass10.class);
                        startActivity(intent);
                    }
                    else if(f==7)
                    {
                        Intent intent=new Intent(Maths.this,MathsClass11.class);
                        startActivity(intent);
                    }
                    else if(f==8)
                    {
                        Intent intent=new Intent(Maths.this,MathsClass12.class);
                        startActivity(intent);
                    }
                    else if(f==9)
                    {
                        Intent intent=new Intent(Maths.this,MathsWBJEE.class);
                        startActivity(intent);
                    }
                    else if(f==10)
                    {
                        Intent intent=new Intent(Maths.this,MathsJEE.class);
                        startActivity(intent);
                    }
                    else if(f==11)
                    {
                        Intent intent=new Intent(Maths.this,MathsOlympiad.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }*/

