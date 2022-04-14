package com.codewithsean.sdw.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codewithsean.sdw.R;
import com.codewithsean.sdw.models.Shows;

import java.util.List;

public class ShowsAdapter extends RecyclerView.Adapter<ShowsAdapter.ViewHolder> {

    Context context;
    List<Shows> shows;

    public ShowsAdapter(Context context, List<Shows> shows){
        this.context = context;
        this.shows = shows;
    }

    @NonNull
    @Override
    public ShowsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("ShowsAdapter", "onCreateViewHolder");
        View showsView = LayoutInflater.from(context).inflate(R.layout.item_shows, parent, false);
        return new ViewHolder(showsView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowsAdapter.ViewHolder holder, int position) {
        Log.d("ShowsAdapter", "onBindViewHolder " + position);
        //get movie passed into position
        Shows show = shows.get(position);
        //bind movie data into VH
        holder.bind(show);
    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout container;
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.tvImage);
        }

        public void bind(Shows shows){
            tvTitle.setText(shows.getOriginal_name());
            tvOverview.setText(shows.getOverview());

            String imageURL;
            imageURL = shows.getPosterPath();

            Glide.with(context).load(imageURL).into(ivPoster);
        }



    }
}
