package com.example.thinkerlab;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Homeadapter extends RecyclerView.Adapter<Homeadapter.ViewHolder> {
    private static final String TAG="Homeadapter";
    private ArrayList<String>title=new ArrayList<>();
    private ArrayList<String>desc=new ArrayList<>();
    private ArrayList<Integer>img=new ArrayList<>();
    private Context context;

    public Homeadapter( Context context,ArrayList<String> title, ArrayList<String> desc, ArrayList<Integer> img) {
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreateViewHolder: called.");
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.features,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"onBindViewHolder: called.");
        Glide.with(context)
                .asBitmap()
                .load(img.get(position))
                .into(holder.img);
        holder.title.setText(title.get(position));
        holder.desc.setText(desc.get(position));
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: Clicked on an image: "+title.get(position));
                Toast.makeText(context,title.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return img.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title,desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img2);
            title=itemView.findViewById(R.id.txt5);
            desc=itemView.findViewById(R.id.txt6);
        }
    }
    /*private List<homehelper> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Homeadapter(List<homehelper> models,Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.features,container,false);
        ImageView img;
        TextView title,desc;

            img=view.findViewById(R.id.img2);
            title=view.findViewById(R.id.txt5);
            desc=view.findViewById(R.id.txt6);
        img.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDescription());

        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
    /*ArrayList<homehelper> fl;

    public Homeadapter(ArrayList<homehelper> fl) {
        this.fl = fl;
    }
    public static class featuredViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title,desc;

        public featuredViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img2);
            title=itemView.findViewById(R.id.txt5);
            desc=itemView.findViewById(R.id.txt6);
        }
    }

    @NonNull
    @Override
    public featuredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.features,parent,false);
        featuredViewHolder f=new featuredViewHolder(view);
        return f;
    }

    @Override
    public void onBindViewHolder(@NonNull featuredViewHolder holder, int position) {
        homehelper homehelper=fl.get(position);
        holder.img.setImageResource(homehelper.getImage());
        holder.title.setText(homehelper.getTitle());
        holder.desc.setText(homehelper.getDescription());

    }



    @Override
    public int getItemCount() {
        return fl.size();
    }*/
}
