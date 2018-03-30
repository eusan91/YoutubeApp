package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeBasePlaylist implements Parcelable{

    private ArrayList<YoutubeInfoPlaylist> items;

    public YoutubeBasePlaylist(ArrayList<YoutubeInfoPlaylist> items) {
        this.items = items;
    }

    protected YoutubeBasePlaylist(Parcel in) {
        items = in.createTypedArrayList(YoutubeInfoPlaylist.CREATOR);
    }

    public static final Creator<YoutubeBasePlaylist> CREATOR = new Creator<YoutubeBasePlaylist>() {
        @Override
        public YoutubeBasePlaylist createFromParcel(Parcel in) {
            return new YoutubeBasePlaylist(in);
        }

        @Override
        public YoutubeBasePlaylist[] newArray(int size) {
            return new YoutubeBasePlaylist[size];
        }
    };

    public ArrayList<YoutubeInfoPlaylist> getItems() {
        return items;
    }

    public void setItems(ArrayList<YoutubeInfoPlaylist> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(items);
    }
}
