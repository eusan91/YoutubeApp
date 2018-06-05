package com.santamaria.youtubeappdemo.View;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.santamaria.youtubeappdemo.Model.YoutubeInfo;
import com.santamaria.youtubeappdemo.Model.YoutubeInfoPlaylist;
import com.santamaria.youtubeappdemo.R;
import com.santamaria.youtubeappdemo.ViewModel.YoutubePlayerViewModel;
import com.santamaria.youtubeappdemo.databinding.ActivityYoutubePlayerBinding;

import static com.santamaria.youtubeappdemo.CONSTANT.GOOGLE_YOUTUBE_API_KEY;

public class YoutubePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String PARCELABLE_VIDEO_KEY = "PARCELABLE_VIDEO_KEY";
    //private String videoId = "";

    ActivityYoutubePlayerBinding binding;
    YoutubePlayerViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_youtube_player);
        viewModel = new YoutubePlayerViewModel();

        binding.setViewModel(viewModel);

        initYoutubePlayer();

        setYoutubeInfo(getIntent().getExtras());

    }

    private void setYoutubeInfo(Bundle bundle) {

        if (bundle != null){

            Parcelable parcelable = bundle.getParcelable(PARCELABLE_VIDEO_KEY);

            if (parcelable instanceof YoutubeInfo){
                YoutubeInfo youtubeBaseChannel = (YoutubeInfo)parcelable;

                viewModel.title.set(youtubeBaseChannel.getSnippet().getTitle());
                viewModel.date.set(youtubeBaseChannel.getSnippet().getPublishetAt());
                viewModel.setVideoId(youtubeBaseChannel.getId().getVideoId());

            } else {
                YoutubeInfoPlaylist youtubeBasePlaylist = (YoutubeInfoPlaylist)parcelable;

                viewModel.title.set(youtubeBasePlaylist.getSnippet().getTitle());
                viewModel.date.set(youtubeBasePlaylist.getSnippet().getPublishetAt());

                viewModel.setVideoId(youtubeBasePlaylist.getSnippet().getResourceId().getVideoId());
            }
        }
    }

    private void initYoutubePlayer() {
        binding.youtubePlayer.initialize(GOOGLE_YOUTUBE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        if (!wasRestored) {
            youTubePlayer.cueVideo(viewModel.getVideoId());
        }

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
