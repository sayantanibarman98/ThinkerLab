package com.example.thinkerlab;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class ChapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    ImageView imageView5;
    TextView txt2,txt3;
    RelativeLayout RL1;
    ItemClickListener itemClickListener;
    Context context;

    public ChapterHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        this.imageView5=itemView.findViewById(R.id.imageView5);
        this.txt2=itemView.findViewById(R.id.txt2);
        this.txt3=itemView.findViewById(R.id.txt3);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //final Intent intent;


        this.itemClickListener.onItemClickListener(v,getLayoutPosition());

    }
    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

}
