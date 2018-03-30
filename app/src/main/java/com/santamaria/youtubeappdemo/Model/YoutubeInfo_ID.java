package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeInfo_ID implements Parcelable {

    private String kind;
    private String videoId;

    public YoutubeInfo_ID(String kind, String videoId) {
        this.kind = kind;
        this.videoId = videoId;
    }

    protected YoutubeInfo_ID(Parcel in) {
        kind = in.readString();
        videoId = in.readString();
    }

    public static final Creator<YoutubeInfo_ID> CREATOR = new Creator<YoutubeInfo_ID>() {
        @Override
        public YoutubeInfo_ID createFromParcel(Parcel in) {
            return new YoutubeInfo_ID(in);
        }

        @Override
        public YoutubeInfo_ID[] newArray(int size) {
            return new YoutubeInfo_ID[size];
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
