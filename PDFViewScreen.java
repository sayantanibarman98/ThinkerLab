package com.example.thinkerlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PDFViewScreen extends AppCompatActivity {
    PDFView pdf1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_d_f_view_screen);
        pdf1=findViewById(R.id.pdf1);
        pdf1.fromAsset("mchp.pdf").load();
    }
}
