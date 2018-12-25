package dragon.bakuman.iu.spotifyscratchaudiostreammitch.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dragon.bakuman.iu.spotifyscratchaudiostreammitch.R;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.adapters.HomeRecyclerAdapter;


public class HomeFragment extends Fragment implements HomeRecyclerAdapter.IHomeSelector {

    private static final String TAG = "HomeFragment";


    // UI Components
    private RecyclerView mRecyclerView;

    // Vars
    private HomeRecyclerAdapter mAdapter;
    private ArrayList<String> mCategories = new ArrayList<>();


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
            mAdapter = new HomeRecyclerAdapter(mCategories, getActivity(), this);
            mRecyclerView.setAdapter(mAdapter);
        }

    }

    @Override
    public void onCategorySelected(int position) {

        Log.d(TAG, "onCategorySelected: list item is clicked");

    }
}















