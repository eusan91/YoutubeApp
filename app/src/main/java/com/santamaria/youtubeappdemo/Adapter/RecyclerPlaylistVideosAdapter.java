package com.santamaria.youtubeappdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.santamaria.youtubeappdemo.Model.YoutubeInfoPlaylist;
import com.santamaria.youtubeappdemo.R;
import com.santamaria.youtubeappdemo.View.YoutubePlayer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class RecyclerPlaylistVideosAdapter extends RecyclerView.Adapter<RecyclerPlaylistVideosAdapter.ViewHolder> {

    private ArrayList<YoutubeInfoPlaylist> playlistVideosList;
    private int layout;

    public RecyclerPlaylistVideosAdapter(ArrayList<YoutubeInfoPlaylist> playlistVideosList, int layout) {
        this.playlistVideosList = playlistVideosList;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        YoutubeInfoPlaylist youtubeInfo = playlistVideosList.get(position);
        holder.textViewTitle.setText(youtubeInfo.getSnippet().getTitle());
        holder.textViewDes.setText(youtubeInfo.getSnippet().getDescription());
        holder.textViewDate.setText(youtubeInfo.getSnippet().getPublishetAt());

        if (youtubeInfo.getSnippet().getThumbnails() !=null)
            Picasso.with(holder.textViewDate.getContext()).load(youtubeInfo.getSnippet().getThumbnails().getHigh().getUrl()).into(holder.ImageThumb);

    }

    @Override
    public int getItemCount() {
        return playlistVideosList == null ? 0 : playlistVideosList.size();
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
                    intent.putExtra(YoutubePlayer.PARCELABLE_VIDEO_KEY, playlistVideosList.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
