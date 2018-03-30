package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeBase implements Parcelable{

    ArrayList<YoutubeInfo> items;

    public YoutubeBase(ArrayList<YoutubeInfo> items) {
        this.items = items;
    }

    public ArrayList<YoutubeInfo> getItems() {
        return items;
    }

    public void setItems(ArrayList<YoutubeInfo> items) {
        this.items = items;
    }

    protected YoutubeBase(Parcel in) {
        items = in.createTypedArrayList(YoutubeInfo.CREATOR);
    }

    public static final Creator<YoutubeBase> CREATOR = new Creator<YoutubeBase>() {
        @Override
        public YoutubeBase createFromParcel(Parcel in) {
            return new YoutubeBase(in);
        }

        @Override
        public YoutubeBase[] newArray(int size) {
            return new YoutubeBase[size];
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
