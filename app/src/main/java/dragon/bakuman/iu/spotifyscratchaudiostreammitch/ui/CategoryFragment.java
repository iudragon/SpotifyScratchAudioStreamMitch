package dragon.bakuman.iu.spotifyscratchaudiostreammitch.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dragon.bakuman.iu.spotifyscratchaudiostreammitch.R;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.adapters.CategoryRecyclerAdapter;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.adapters.HomeRecyclerAdapter;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.models.Artist;


public class CategoryFragment extends Fragment implements CategoryRecyclerAdapter.ICategorySelector {

    private static final String TAG = "CategoryFragment";


    // UI Components
    private RecyclerView mRecyclerView;


    // Vars
    private CategoryRecyclerAdapter mAdapter;
    private ArrayList<Artist> mArtists = new ArrayList<>();
    private IMainActivity mIMainActivity;
    private String mSelectedCategory;

    public static CategoryFragment newInstance(String category) {

        CategoryFragment categoryFragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString("category", category);
        categoryFragment.setArguments(args);
        return categoryFragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mSelectedCategory = getArguments().getString("category");

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

    private void initRecyclerView(View view) {

        if (mRecyclerView == null) {

            mRecyclerView = view.findViewById(R.id.recycler_view);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mAdapter = new CategoryRecyclerAdapter(getActivity(), mArtists, this);
            mRecyclerView.setAdapter(mAdapter);
        }

    }


    @Override
    public void onArtistSelected(int position) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (IMainActivity) getActivity();
    }
}















