//package com.google.android.youtube.player;

import android.app.Activity;
import android.os.Bundle;

import com.example.wylsacom.MainActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubePlayerViewUtils {

    public static YouTubePlayerView createYouTubePlayerView(final Activity activity,
                                                            final YouTubePlayer.OnInitializedListener initializedListener,
                                                            final Bundle playerState) {
        // create YoutubePlayerView by private-package constructor
        final YouTubePlayerView view = new YouTubePlayerView(activity, /*AttributeSet*/ null, /*defStyleAttr*/ 0,
                new YouTubePlayerView.b() {
                    @Override
                    public void a(YouTubePlayerView view,
                                  String apiKey,
                                  YouTubePlayer.OnInitializedListener listener) {
                        view.a(activity, view, apiKey, listener, playerState);
                    }

                    @Override
                    public void a(YouTubePlayerView view) {
                        // Do Nothing
                    }
                });

        //initialize YoutubePlayerView with API Key and OnInitializedListener
        view.initialize("AIzaSyBi_bbdLuwc_-4vgTszzFt0F26EtWSJCDk", initializedListener);

        return view;
    }

    public static Bundle getPlayerState(YouTubePlayerView view) {
        return view.e();
    }

    /**
     * The following methods sync from YouTubePlayerFragment and YouTubePlayerActivity
     * We need to call these method by Fragment's lifecycle
     */
    public static void start(YouTubePlayerView view) {
        view.a();
    }

    public static void resume(YouTubePlayerView view) {
        view.b();
    }

    public static void pause(YouTubePlayerView view) {
        view.c();
    }

    public static void stop(YouTubePlayerView view) {
        view.d();
    }

    public static void destroyView(YouTubePlayerView view, boolean isFinishing) {
        view.c(isFinishing);
    }

    public static void destroy(YouTubePlayerView view, boolean isFinishing) {
        view.b(isFinishing);
    }
}
