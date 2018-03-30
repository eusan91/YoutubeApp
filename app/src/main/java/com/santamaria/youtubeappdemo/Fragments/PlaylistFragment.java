package com.santamaria.youtubeappdemo.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santamaria.youtubeappdemo.Adapter.RecyclerPlaylistVideosAdapter;
import com.santamaria.youtubeappdemo.Model.YoutubeBasePlaylist;
import com.santamaria.youtubeappdemo.Model.YoutubeInfoPlaylist;
import com.santamaria.youtubeappdemo.R;
import com.santamaria.youtubeappdemo.Services.ServiceGetPlaylistVideos;

import java.util.ArrayList;

public class PlaylistFragment extends Fragment {

    private ArrayList<YoutubeInfoPlaylist> playListVideosList;
    private RecyclerView recyclerView;
    private Context context;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent != null){
                setPlayListVideos(intent.getParcelableExtra(ServiceGetPlaylistVideos.LIST_POST_RESPONSE));
            }
        }
    };

    public PlaylistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist, container, false);
        recyclerView = view.findViewById(R.id.idRecyclerViewPlaylist);

        Intent intent = new Intent(getContext(), ServiceGetPlaylistVideos.class);
        context.startService(intent);

        return view;
    }

    // Utility methods
    private void setPlayListVideos(Parcelable parcelableArrayListExtra) {

        YoutubeBasePlaylist youtubeBasePlaylist = (YoutubeBasePlaylist)parcelableArrayListExtra;
        playListVideosList = youtubeBasePlaylist.getItems();

        loadRecyclerView();
    }


    private void loadRecyclerView() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerPlaylistVideosAdapter adapter = new RecyclerPlaylistVideosAdapter(playListVideosList, R.layout.youtube_video_item);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        context.registerReceiver(receiver, new IntentFilter(ServiceGetPlaylistVideos.NOTIFICATION));
    }

    @Override
    public void onDetach() {
        super.onDetach();

        context.unregisterReceiver(receiver);
    }
}
