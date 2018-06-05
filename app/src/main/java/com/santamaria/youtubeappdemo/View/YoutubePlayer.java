package com.santamaria.youtubeappdemo.View;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.santamaria.youtubeappdemo.Model.YoutubeInfo;
import com.santamaria.youtubeappdemo.Model.YoutubeInfoPlaylist;
import com.santamaria.youtubeappdemo.R;

import static com.santamaria.youtubeappdemo.CONSTANT.GOOGLE_YOUTUBE_API_KEY;

public class YoutubePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String PARCELABLE_VIDEO_KEY = "PARCELABLE_VIDEO_KEY";
    private TextView textViewName;
    private TextView textViewDate;
    private YouTubePlayerView mYoutubePlayerView = null;
    private YouTubePlayer mYoutubePlayer = null;
    private String videoId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

        initViews();

        Bundle bundle = getIntent().getExtras();
        
        if (bundle != null){
            
            Parcelable parcelable = bundle.getParcelable(PARCELABLE_VIDEO_KEY);

            if (parcelable instanceof YoutubeInfo){
                YoutubeInfo youtubeBaseChannel = (YoutubeInfo)parcelable;

                textViewName.setText(youtubeBaseChannel.getSnippet().getTitle());
                textViewDate.setText(youtubeBaseChannel.getSnippet().getPublishetAt());
                videoId = youtubeBaseChannel.getId().getVideoId();

            } else {
                YoutubeInfoPlaylist youtubeBasePlaylist = (YoutubeInfoPlaylist)parcelable;

                textViewName.setText(youtubeBasePlaylist.getSnippet().getTitle());
                textViewDate.setText(youtubeBasePlaylist.getSnippet().getPublishetAt());
                videoId = youtubeBasePlaylist.getSnippet().getResourceId().getVideoId();
            }
        }
    }

    private void initViews() {

        mYoutubePlayerView = findViewById(R.id.youtube_player);
        mYoutubePlayerView.initialize(GOOGLE_YOUTUBE_API_KEY, this);
        textViewName = findViewById(R.id.textViewName);
        textViewDate = findViewById(R.id.textViewDate);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        if (!wasRestored) {
            youTubePlayer.cueVideo(videoId);
        }
        mYoutubePlayer = youTubePlayer;

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }


    ///---------------------

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };
}
