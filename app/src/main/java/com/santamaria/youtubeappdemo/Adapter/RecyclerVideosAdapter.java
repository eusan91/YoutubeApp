package com.santamaria.youtubeappdemo.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.santamaria.youtubeappdemo.Model.YoutubeInfo;
import com.santamaria.youtubeappdemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class RecyclerVideosAdapter extends RecyclerView.Adapter<RecyclerVideosAdapter.ViewHolder> {

    private ArrayList<YoutubeInfo> channelVideosList;
    private int layout;

    public RecyclerVideosAdapter(ArrayList<YoutubeInfo> channelVideosList, int layout) {
        this.channelVideosList = channelVideosList;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        YoutubeInfo youtubeInfo = channelVideosList.get(position);
        holder.textViewTitle.setText(youtubeInfo.getSnippet().getTitle());
        holder.textViewDes.setText(youtubeInfo.getSnippet().getDescription());
        holder.textViewDate.setText(youtubeInfo.getSnippet().getPublishetAt());

        Picasso.with(holder.textViewDate.getContext()).load(youtubeInfo.getSnippet().getThumbnails().getHigh().getUrl()).into(holder.ImageThumb);

    }

    @Override
    public int getItemCount() {

        if (channelVideosList == null){
            return 0;
        } else if (channelVideosList.size() > 0){
            return channelVideosList.size()-1;
        } else {
            return 0;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDes;
        TextView textViewDate;
        ImageView ImageThumb;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewTitle = itemView.findViewById(R.id.textViewTitle);
            this.textViewDes = itemView.findViewById(R.id.textViewDes);
            this.textViewDate = itemView.findViewById(R.id.textViewDate);
            this.ImageThumb = itemView.findViewById(R.id.ImageThumb);

        }
    }
}
