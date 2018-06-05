package com.santamaria.youtubeappdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santamaria.youtubeappdemo.Model.YoutubeInfoPlaylist;
import com.santamaria.youtubeappdemo.View.YoutubePlayer;
import com.santamaria.youtubeappdemo.databinding.YoutubePlaylistVideoItemBinding;
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
        holder.bind(playlistVideosList.get(position));
    }

    @Override
    public int getItemCount() {
        return playlistVideosList == null ? 0 : playlistVideosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        YoutubePlaylistVideoItemBinding binder;

        public ViewHolder(View itemView) {
            super(itemView);
            binder = DataBindingUtil.bind(itemView);

        }

        void bind(YoutubeInfoPlaylist youtubeInfoPlaylist){

            binder.setYoutubeInfoPlaylist(youtubeInfoPlaylist);
            Picasso.get().load(youtubeInfoPlaylist.getSnippet().getThumbnails().getHigh().getUrl()).into(binder.ImageThumb);
            binder.ImageThumb.setOnClickListener(new View.OnClickListener() {
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
