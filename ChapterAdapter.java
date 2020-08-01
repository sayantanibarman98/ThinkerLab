package com.example.thinkerlab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ChapterViewHolder> implements Filterable {
    Context context;
    List<ChaptersItem> list;
    List<ChaptersItem> filtered;
    private RecyclerViewClickListener listener;
    //final private ListItemClickListener mOnClickListener;

    public ChapterAdapter(Context context, List<ChaptersItem> list, RecyclerViewClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener=listener;
        this.filtered=list;
       // mOnClickListener = listener1;
    }
    public ChapterAdapter() {
    }
    @NonNull
    @Override
    public ChapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout= LayoutInflater.from(context).inflate(R.layout.chapters,parent,false);
        return new ChapterViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull final ChapterViewHolder holder, final int position) {


        holder.RL1.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation));
        holder.txt2.setText(filtered.get(position).getChapter());
       holder.txt3.setText(filtered.get(position).getVarieties());
       holder.txt4.setText(filtered.get(position).getPrice());
        holder.imageView5.setImageResource(filtered.get(position).getUserPhoto());
    //    holder.bind(position);

       holder.RL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent;
               switch (position) {
                    case 0:
                        intent = new Intent(context, BuildingWithBricks.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);
                        break;
                   case 2:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(context,Payment.class);
                        context.startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(context,Payment.class);
                        context.startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(context,Payment.class);
                        context.startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(context, Payment.class);
                        context.startActivity(intent);

            }
        }
    });
    }

    @Override
    public int getItemCount() {
        return filtered.size();
    }

    @Override
    public  Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key=constraint.toString();
                if(key.isEmpty())
                {
                    filtered=list;
                }
                else
                {
                    List<ChaptersItem> IsFiltered=new ArrayList<>();
                    for(ChaptersItem row : list)
                    {
                        if(row.getChapter().toLowerCase().contains(key.toLowerCase()))
                        {
                            IsFiltered.add(row);
                        }
                    }
                    filtered=IsFiltered;
                }
                FilterResults filterResults=new FilterResults();
                filterResults.values=filtered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
              filtered= (List<ChaptersItem>) results.values;
              notifyDataSetChanged();
            }
        };
    }


    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }


    public class ChapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txt2, txt3,txt4;
        ImageView imageView5;
        RelativeLayout RL1;


        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            RL1=itemView.findViewById(R.id.RL1);
            txt2=itemView.findViewById(R.id.txt2);
            txt3=itemView.findViewById(R.id.txt3);
            txt4=itemView.findViewById(R.id.txt4);
            imageView5=itemView.findViewById(R.id.imageView5);
            itemView.setOnClickListener(this);
        }
       /* void bind(int listIndex) {
            txt2.setText(listener(listIndex);
        }*/

        @Override
        public void onClick(View v) {
           // int clickedPosition = getAdapterPosition();
           // listener.onClick(clickedPosition);
             listener.onClick(v,getAdapterPosition());

        }
    }
}
