package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeBaseChannel implements Parcelable{

    ArrayList<YoutubeInfo> items;

    public YoutubeBaseChannel(ArrayList<YoutubeInfo> items) {
        this.items = items;
    }

    public ArrayList<YoutubeInfo> getItems() {
        return items;
    }

    public void setItems(ArrayList<YoutubeInfo> items) {
        this.items = items;
    }

    protected YoutubeBaseChannel(Parcel in) {
        items = in.createTypedArrayList(YoutubeInfo.CREATOR);
    }

    public static final Creator<YoutubeBaseChannel> CREATOR = new Creator<YoutubeBaseChannel>() {
        @Override
        public YoutubeBaseChannel createFromParcel(Parcel in) {
            return new YoutubeBaseChannel(in);
        }

        @Override
        public YoutubeBaseChannel[] newArray(int size) {
            return new YoutubeBaseChannel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(items);
    }
}
