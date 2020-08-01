package com.example.thinkerlab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TechnologyAdapter extends RecyclerView.Adapter<TechnologyAdapter.MyViewHolder> {
    private Context context;
    private List<TechnologyStart> Data;
    private TechnologyAdapter.RecyclerViewClickListener listener;

    public TechnologyAdapter(Context context, List<TechnologyStart> data, TechnologyAdapter.RecyclerViewClickListener listener) {
        this.context = context;
        this.Data = data;
        this.listener=listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        //LayoutInflater inflater=LayoutInflater.from(context);
        view=LayoutInflater.from(context).inflate(R.layout.cardview_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.title.setText(Data.get(position).getTitle());
        holder.img_thumbnail.setImageResource(Data.get(position).getThumbnail());
        holder.img_thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context, BasicsPython.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, FundC.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, FundCP.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, DSA.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(context, EFK.class);
                        context.startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 14:
                        intent = new Intent(context, Java.class);
                        context.startActivity(intent);
                        break;
                    case 15:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 16:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;
                    case 17:
                        intent = new Intent(context, Engineering.class);
                        context.startActivity(intent);
                        break;


            }
        }
    });
    }
    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }


    @Override
    public int getItemCount() {
        return Data.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
         ImageView img_thumbnail;
         TextView title;
         LinearLayout LL1;
        public MyViewHolder(View itemView)
        {
            super(itemView);
           // LL1=itemView.findViewById(R.id.TechLL);
            img_thumbnail=(ImageView)itemView.findViewById(R.id.img1);
            title=(TextView)itemView.findViewById(R.id.txt1);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            //listener.onClick(v,getAdapterPosition());

        }
    }
}


