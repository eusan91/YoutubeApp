package com.santamaria.youtubeappdemo.Retrofit;

import com.santamaria.youtubeappdemo.Model.YoutubeBase;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Santamaria on 29/03/2018.
 */

public interface YouTubeApiService {

    @GET("youtube/v3/search")
    Call<YoutubeBase> listChannelVideos(@Query("part") String part,
                                                   @Query("order") String order,
                                                   @Query("channelId") String channelId,
                                                   @Query("maxResults") String maxResults,
                                                   @Query("key") String key);


}
