package com.google.android.youtube.player;

import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;

public class YouTubeDemoFragment extends android.support.v4.app.Fragment {

    private YouTubePlayerView mYouTubePlayerView;
    private Bundle mYouTubePlayerState;
    private OnInitializedListener mOnYoutubePlayerInitializedListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mYouTubePlayerState =
                savedInstanceState != null ? savedInstanceState.getBundle("YouTubeDemoFragment.KEY_PLAYER_VIEW_STATE") : null;

        mOnYoutubePlayerInitializedListener = new OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                YouTubePlayer player,
                                                boolean wasRestored) {
                if (player == null) {
                    return;
                }
                player.cueVideo(mYoutubeVideoId);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult result) {
                // error handling
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_youtube_demo, container, false);

        mYouTubePlayerView = YouTubePlayerViewUtils.createYouTubePlayerView(getActivity(), mOnYoutubePlayerInitListener, mPlayerState);
        // Add mYouTubePlayerView into view as you need.

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        YouTubePlayerViewUtils.start(mYouTubePlayerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        YouTubePlayerViewUtils.resume(mYouTubePlayerView);
    }

    @Override
    public void onPause() {
        super.onPause();
        YouTubePlayerViewUtils.pause(mYouTubePlayerView);
    }

    @Override
    public void onStop() {
        super.onStop();
        YouTubePlayerViewUtils.stop(mYouTubePlayerView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        YouTubePlayerViewUtils.destroyView(mYouTubePlayerView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        YouTubePlayerViewUtils.destroy(mYouTubePlayerView);
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putBundle("YouTubeDemoFragment.KEY_PLAYER_VIEW_STATE", getPlayerState());
    }

    private Bundle getPlayerState() {
        return mYouTubePlayerView == null ? mYouTubePlayerState : YouTubePlayerViewUtils.getPlayerState(mYouTubePlayerView);
    }
}
    view raw