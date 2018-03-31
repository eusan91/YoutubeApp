package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Santamaria on 30/03/2018.
 */

public class YoutubeInfoPlaylist_Snippet_ResourceId implements Parcelable{

    private String kind;
    private String videoId;

    public YoutubeInfoPlaylist_Snippet_ResourceId(String kind, String videoId) {
        this.kind = kind;
        this.videoId = videoId;
    }

    protected YoutubeInfoPlaylist_Snippet_ResourceId(Parcel in) {
        kind = in.readString();
        videoId = in.readString();
    }

    public static final Creator<YoutubeInfoPlaylist_Snippet_ResourceId> CREATOR = new Creator<YoutubeInfoPlaylist_Snippet_ResourceId>() {
        @Override
        public YoutubeInfoPlaylist_Snippet_ResourceId createFromParcel(Parcel in) {
            return new YoutubeInfoPlaylist_Snippet_ResourceId(in);
        }

        @Override
        public YoutubeInfoPlaylist_Snippet_ResourceId[] newArray(int size) {
            return new YoutubeInfoPlaylist_Snippet_ResourceId[size];
        }
    };

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kind);
        dest.writeString(videoId);
    }
}
