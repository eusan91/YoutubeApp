package com.santamaria.youtubeappdemo.Services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import com.santamaria.youtubeappdemo.Model.YoutubeBasePlaylist;
import com.santamaria.youtubeappdemo.Retrofit.YoutubeApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.santamaria.youtubeappdemo.CONSTANT.BASE_URL;
import static com.santamaria.youtubeappdemo.CONSTANT.GOOGLE_YOUTUBE_API_KEY;
import static com.santamaria.youtubeappdemo.CONSTANT.PLAYLIST_ID;

public class ServiceGetPlaylistVideos extends Service {

    public static final String NOTIFICATION = "com.santamaria.youtubeappdemo.playlist.downloaded";
    public static final String LIST_POST_RESPONSE = "LIST_POST_RESPONSE";

    public ServiceGetPlaylistVideos() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        YoutubeApi.getVideos(BASE_URL)
                .listPlaylistVideos("snippet", PLAYLIST_ID, "20", GOOGLE_YOUTUBE_API_KEY)
                    .enqueue(new Callback<YoutubeBasePlaylist>() {
            @Override
            public void onResponse(Call<YoutubeBasePlaylist> call, Response<YoutubeBasePlaylist> response) {

                if( response != null && response.isSuccessful()){
                    publishResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<YoutubeBasePlaylist> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "FAILURE", Toast.LENGTH_SHORT).show();
            }
        });

        return super.onStartCommand(intent, flags, startId);
    }

    private void publishResponse(YoutubeBasePlaylist body) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(LIST_POST_RESPONSE, body);
        sendBroadcast(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
