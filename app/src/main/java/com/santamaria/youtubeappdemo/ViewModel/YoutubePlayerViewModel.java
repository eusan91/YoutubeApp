package com.santamaria.youtubeappdemo.ViewModel;

import android.databinding.ObservableField;

public class YoutubePlayerViewModel {

    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> date = new ObservableField<>();
    private String videoId = "";

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
