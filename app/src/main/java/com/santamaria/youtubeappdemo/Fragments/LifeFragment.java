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

import com.santamaria.youtubeappdemo.Adapter.RecyclerChannelVideosAdapter;
import com.santamaria.youtubeappdemo.Model.YoutubeBaseChannel;
import com.santamaria.youtubeappdemo.Model.YoutubeInfo;
import com.santamaria.youtubeappdemo.R;
import com.santamaria.youtubeappdemo.Services.ServiceGetLivelistVideos;

import java.util.ArrayList;

public class LifeFragment extends Fragment {

    private ArrayList<YoutubeInfo> channelVideosList;
    private RecyclerView recyclerView;
    private Context context;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if (intent != null){
                setChannelVideos(intent.getParcelableExtra(ServiceGetLivelistVideos.LIST_POST_RESPONSE));
            }
        }
    };

    public LifeFragment() {
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



        Intent intent = new Intent(getContext(), ServiceGetLivelistVideos.class);
        context.startService(intent);



        return view;
    }

    // Utility methods
    private void setChannelVideos(Parcelable parcelableArrayListExtra) {

        YoutubeBaseChannel youtubeBaseChannel = (YoutubeBaseChannel)parcelableArrayListExtra;
        channelVideosList = youtubeBaseChannel.getItems();

        loadRecyclerView();
    }


    private void loadRecyclerView() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerChannelVideosAdapter adapter = new RecyclerChannelVideosAdapter(channelVideosList, R.layout.youtube_video_item);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        context.registerReceiver(receiver, new IntentFilter(ServiceGetLivelistVideos.NOTIFICATION));
    }

    @Override
    public void onDetach() {
        super.onDetach();

        context.unregisterReceiver(receiver);
    }
}
