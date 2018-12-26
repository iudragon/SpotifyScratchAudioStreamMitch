package dragon.bakuman.iu.spotifyscratchaudiostreammitch.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dragon.bakuman.iu.spotifyscratchaudiostreammitch.R;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.adapters.CategoryRecyclerAdapter;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.adapters.PlaylistRecyclerAdapter;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.models.Artist;


public class PlaylistFragment extends Fragment implements PlaylistRecyclerAdapter.IMediaSelector {

    private static final String TAG = "PlaylistFragment";

    // UI Components
    private RecyclerView mRecyclerView;


    // Vars
    private PlaylistRecyclerAdapter mAdapter;
    private ArrayList<MediaMetadataCompat> mMediaList = new ArrayList<>();
    private IMainActivity mIMainActivity;
    private String mSelectedCategory;
    private Artist mSelectedArtist;
    private MediaMetadataCompat mSelectedMedia;

    public static PlaylistFragment newInstance(String category, Artist artist) {

        PlaylistFragment playlistFragment = new PlaylistFragment();
        Bundle args = new Bundle();
        args.putString("category", category);
        args.putParcelable("artist", artist);
        playlistFragment.setArguments(args);
        return playlistFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSelectedCategory = getArguments().getString("category");
            mSelectedArtist = getArguments().getParcelable("artist"); //parcelable because it is a cutome objecta

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initRecyclerView(view);
    }

    private void updateDataset(){

        mIMainActivity.hideProgressBar();
        mAdapter.notifyDataSetChanged();

    }

    private void initRecyclerView(View view) {

        if (mRecyclerView == null) {

            mRecyclerView = view.findViewById(R.id.recycler_view);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mAdapter = new PlaylistRecyclerAdapter(getActivity(), mMediaList, this);
            mRecyclerView.setAdapter(mAdapter);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (IMainActivity) getActivity();
    }


    @Override
    public void onMediaSelected(int position) {

    }
}















