package com.example.thinkerlab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class DocsFragment extends Fragment {
CardView ab;


    public DocsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x =  inflater.inflate(R.layout.fragment_docs, container, false);
        ab = (CardView) x.findViewById(R.id.card1);
        OnClickListener listnr=new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(),PDFViewScreen.class);
                startActivity(i);
            }
        };
        ab.setOnClickListener(listnr);
        return x;

    }
}
