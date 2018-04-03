package com.santamaria.youtubeappdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.santamaria.youtubeappdemo.Model.YoutubeInfo;
import com.santamaria.youtubeappdemo.Model.YoutubeInfoPlaylist;
import com.santamaria.youtubeappdemo.R;
import com.santamaria.youtubeappdemo.View.YoutubePlayer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class RecyclerChannelVideosAdapter extends RecyclerView.Adapter<RecyclerChannelVideosAdapter.ViewHolder> {

    private ArrayList<YoutubeInfo> channelVideosList;
    private int layout;

    public RecyclerChannelVideosAdapter(ArrayList<YoutubeInfo> channelVideosList, int layout) {
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

            this.ImageThumb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();

                    Intent intent = new Intent(context, YoutubePlayer.class);
                    intent.putExtra(YoutubePlayer.PARCELABLE_VIDEO_KEY, channelVideosList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
