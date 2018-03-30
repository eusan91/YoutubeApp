package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeInfo implements Parcelable{

    private YoutubeInfo_ID id;
    private YoutubeInfo_Snippet snippet;

    public YoutubeInfo(YoutubeInfo_ID id, YoutubeInfo_Snippet snippet) {

        this.id = id;
        this.snippet = snippet;
    }

    protected YoutubeInfo(Parcel in) {
        id = in.readParcelable(YoutubeInfo_ID.class.getClassLoader());
        snippet = in.readParcelable(YoutubeInfo_Snippet.class.getClassLoader());
    }

    public static final Creator<YoutubeInfo> CREATOR = new Creator<YoutubeInfo>() {
        @Override
        public YoutubeInfo createFromParcel(Parcel in) {
            return new YoutubeInfo(in);
        }

        @Override
        public YoutubeInfo[] newArray(int size) {
            return new YoutubeInfo[size];
        }
    };

    public YoutubeInfo_ID getId() {
        return id;
    }

    public void setId(YoutubeInfo_ID id) {
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
        dest.writeParcelable(id, flags);
        dest.writeParcelable(snippet, flags);
    }
}
