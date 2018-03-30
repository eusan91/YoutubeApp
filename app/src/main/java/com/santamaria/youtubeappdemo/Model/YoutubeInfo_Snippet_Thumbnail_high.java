package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeInfo_Snippet_Thumbnail_high implements Parcelable{

    private String url;
    private int width;
    private int height;

    public YoutubeInfo_Snippet_Thumbnail_high(String url, int width, int height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    protected YoutubeInfo_Snippet_Thumbnail_high(Parcel in) {
        url = in.readString();
        width = in.readInt();
        height = in.readInt();
    }

    public static final Creator<YoutubeInfo_Snippet_Thumbnail_high> CREATOR = new Creator<YoutubeInfo_Snippet_Thumbnail_high>() {
        @Override
        public YoutubeInfo_Snippet_Thumbnail_high createFromParcel(Parcel in) {
            return new YoutubeInfo_Snippet_Thumbnail_high(in);
        }

        @Override
        public YoutubeInfo_Snippet_Thumbnail_high[] newArray(int size) {
            return new YoutubeInfo_Snippet_Thumbnail_high[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeInt(width);
        dest.writeInt(height);
    }
}
