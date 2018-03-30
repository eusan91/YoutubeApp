package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeInfoPlaylist implements Parcelable {


    private String id;
    private YoutubeInfo_Snippet snippet;

    public YoutubeInfoPlaylist(String id, YoutubeInfo_Snippet snippet) {

        this.id = id;
        this.snippet = snippet;
    }

    protected YoutubeInfoPlaylist(Parcel in) {
        id = in.readString();
        snippet = in.readParcelable(YoutubeInfo_Snippet.class.getClassLoader());
    }

    public static final Parcelable.Creator<YoutubeInfoPlaylist> CREATOR = new Parcelable.Creator<YoutubeInfoPlaylist>() {
        @Override
        public YoutubeInfoPlaylist createFromParcel(Parcel in) {
            return new YoutubeInfoPlaylist(in);
        }

        @Override
        public YoutubeInfoPlaylist[] newArray(int size) {
            return new YoutubeInfoPlaylist[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public YoutubeInfo_Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(YoutubeInfo_Snippet snippet) {
        this.snippet = snippet;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeParcelable(snippet, flags);
    }
}
