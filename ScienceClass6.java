package com.example.thinkerlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ScienceClass6 extends AppCompatActivity {
    RecyclerView recyclerView;
    ChapterAdapter chapterAdapter;
    private ChapterAdapter.RecyclerViewClickListener listener;
    EditText search;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_science_class6);
        recyclerView=findViewById(R.id.RV1);
        search=findViewById(R.id.search);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScienceClass6.this,Science.class));
            }
        });
        List<ChaptersItem> list=new ArrayList<>();
        list.add(new ChaptersItem("1. Food: Where Does It Come From?","0 Tests | 0 Docs | 0 Videos","FREE ",R.drawable.next));
        list.add(new ChaptersItem("2. Components of Food","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("3. Fibre to Fabric","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("4. Sorting Materials and Groups","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("5. Separation of Substances","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("6. Changes Around Us","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("7. Getting to Know Plants","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("8. Body Movement","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("9. The Living Organisms and Their Surroundings","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("10. Motion and Measurement of Distances","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("11. Light, Shadows and Reflections","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("12. Electricity and Circuits","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("13. Fun with Magnets","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("14. Water","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("15. Air Around Us","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("16. Garbage In, Garbage Out","0 Tests | 0 Docs | 0 Videos","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("17. Topic-Wise Test","0 Docs","Buy Now: Rs 99",R.drawable.next));
        list.add(new ChaptersItem("18. Mock Test","0 Docs","Buy Now: Rs 99",R.drawable.next));
        setOnClickListener();
        chapterAdapter= new ChapterAdapter(this,list,listener);
        recyclerView.setAdapter(chapterAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                chapterAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private void setOnClickListener()
    {
        listener=new ChapterAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent=new Intent(getApplicationContext(),BuildingWithBricks.class);
                startActivity(intent);

            }
        };
    }
}
