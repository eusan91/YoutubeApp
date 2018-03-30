package com.santamaria.youtubeappdemo.Fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santamaria.youtubeappdemo.Adapter.RecyclerVideosAdapter;
import com.santamaria.youtubeappdemo.Model.YoutubeBase;
import com.santamaria.youtubeappdemo.Model.YoutubeInfo;
import com.santamaria.youtubeappdemo.R;
import com.santamaria.youtubeappdemo.Services.ServiceGetChannelVideos;

import java.util.ArrayList;

public class ChannelFragment extends Fragment {

    private ArrayList<YoutubeInfo> channelVideosList;
    private RecyclerView recyclerView;
    private Context context;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent != null){
                setChannelVideos(intent.getParcelableExtra(ServiceGetChannelVideos.LIST_POST_RESPONSE));
            }
        }
    };

    public ChannelFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel, container, false);
        recyclerView = view.findViewById(R.id.idRecyclerViewChannel);



        Intent intent = new Intent(getContext(), ServiceGetChannelVideos.class);
        context.startService(intent);



        return view;
    }

    // Utility methods
    private void setChannelVideos(Parcelable parcelableArrayListExtra) {

        YoutubeBase youtubeBase = (YoutubeBase)parcelableArrayListExtra;
        channelVideosList = youtubeBase.getItems();

        loadRecyclerView();
    }


    private void loadRecyclerView() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerVideosAdapter adapter = new RecyclerVideosAdapter(channelVideosList, R.layout.youtube_video_item);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        context.registerReceiver(receiver, new IntentFilter(ServiceGetChannelVideos.NOTIFICATION));
    }

    @Override
    public void onDetach() {
        super.onDetach();

        context.unregisterReceiver(receiver);
    }
}
