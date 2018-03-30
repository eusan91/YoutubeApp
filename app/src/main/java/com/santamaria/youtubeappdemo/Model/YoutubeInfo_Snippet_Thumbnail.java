package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeInfo_Snippet_Thumbnail implements Parcelable{

    private YoutubeInfo_Snippet_Thumbnail_high high;

    public YoutubeInfo_Snippet_Thumbnail(YoutubeInfo_Snippet_Thumbnail_high high) {
        this.high = high;
    }

    protected YoutubeInfo_Snippet_Thumbnail(Parcel in) {
        high = in.readParcelable(YoutubeInfo_Snippet_Thumbnail_high.class.getClassLoader());
    }

    public static final Creator<YoutubeInfo_Snippet_Thumbnail> CREATOR = new Creator<YoutubeInfo_Snippet_Thumbnail>() {
        @Override
        public YoutubeInfo_Snippet_Thumbnail createFromParcel(Parcel in) {
            return new YoutubeInfo_Snippet_Thumbnail(in);
        }

        @Override
        public YoutubeInfo_Snippet_Thumbnail[] newArray(int size) {
            return new YoutubeInfo_Snippet_Thumbnail[size];
        }
    };

    public YoutubeInfo_Snippet_Thumbnail_high getHigh() {
        return high;
    }

    public void setHigh(YoutubeInfo_Snippet_Thumbnail_high high) {
        this.high = high;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(high, flags);
    }
}
