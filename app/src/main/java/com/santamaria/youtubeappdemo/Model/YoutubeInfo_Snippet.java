package com.santamaria.youtubeappdemo.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Santamaria on 29/03/2018.
 */

public class YoutubeInfo_Snippet implements Parcelable {

    private String publishetAt;
    private String channelId;
    private String title;
    private String description;
    private YoutubeInfo_Snippet_Thumbnail thumbnails;

    public YoutubeInfo_Snippet(String publishetAt, String channelId, String title, String description, YoutubeInfo_Snippet_Thumbnail thumbnails) {
        this.publishetAt = publishetAt;
        this.channelId = channelId;
        this.title = title;
        this.description = description;
        this.thumbnails = thumbnails;
    }

    protected YoutubeInfo_Snippet(Parcel in) {
       // publishetAt = in.readString();
        channelId = in.readString();
        title = in.readString();
        description = in.readString();
        thumbnails = in.readParcelable(YoutubeInfo_Snippet_Thumbnail.class.getClassLoader());
    }

    public static final Creator<YoutubeInfo_Snippet> CREATOR = new Creator<YoutubeInfo_Snippet>() {
        @Override
        public YoutubeInfo_Snippet createFromParcel(Parcel in) {
            return new YoutubeInfo_Snippet(in);
        }

        @Override
        public YoutubeInfo_Snippet[] newArray(int size) {
            return new YoutubeInfo_Snippet[size];
        }
    };

    public String getPublishetAt() {
        return publishetAt;
    }
    public void setPublishetAt(String publishetAt) {
        this.publishetAt = publishetAt;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public YoutubeInfo_Snippet_Thumbnail getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(YoutubeInfo_Snippet_Thumbnail thumbnails) {
        this.thumbnails = thumbnails;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
       // dest.writeString(publishetAt);
        dest.writeString(channelId);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeParcelable(thumbnails, flags);
    }
}
