package com.santamaria.youtubeappdemo.Retrofit;

import com.santamaria.youtubeappdemo.Model.YoutubeBaseChannel;
import com.santamaria.youtubeappdemo.Model.YoutubeBasePlaylist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Santamaria on 29/03/2018.
 */

public interface YouTubeApiService {

    @GET("youtube/v3/search")
    Call<YoutubeBaseChannel> listChannelVideos(@Query("part") String part,
                                               @Query("order") String order,
                                               @Query("channelId") String channelId,
                                               @Query("maxResults") String maxResults,
                                               @Query("key") String key);

    @GET("youtube/v3/playlistItems")
    Call<YoutubeBasePlaylist> listPlaylistVideos(@Query("part") String part,
                                                 @Query("playlistId") String channelId,
                                                 @Query("maxResults") String maxResults,
                                                 @Query("key") String key);

}
