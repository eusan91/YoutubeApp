package com.santamaria.youtubeappdemo.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeApi {

    public static YouTubeApiService getChannelVideos(String url){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(YouTubeApiService.class);
    }
}
