package com.example.myapplication.bitcoin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.technology.Technology;
import com.example.myapplication.technology.WebForTech;

import java.util.ArrayList;

public class BitCoinAdapter extends RecyclerView.Adapter<BitCoinAdapter.ViewHolder> {
    ArrayList<Bitcoin> newsList3;
    Context context;
   Bitcoin news;
    public BitCoinAdapter(ArrayList<Bitcoin> newsList, Context context) {
        this.newsList3 = newsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int a) {
       news=newsList3.get(a);
       holder.newsTitle.setText(news.newsTitle);
       holder.newsDesc.setText(news.newsDescription);
       holder.newsDate.setText(news.newDate);
       holder.newsArthur.setText(news.newsArthur);
        Glide.with(context)
                .load(news.newsImage)
                .into(holder.newsImage);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, WebForBitCoin.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                WebForBitCoin.url =news.url;
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return newsList3.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  newsDate,newsTitle,newsDesc,newsArthur;
        ImageView newsImage;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsArthur=itemView.findViewById(R.id.newArthur);
            newsDate=itemView.findViewById(R.id.newDate);
            newsDesc=itemView.findViewById(R.id.newsDesc);
            newsImage=itemView.findViewById(R.id.newImage);
            newsTitle=itemView.findViewById(R.id.newTitle);
            relativeLayout=itemView.findViewById(R.id.relative);
        }
    }
}
