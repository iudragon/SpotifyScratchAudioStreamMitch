package dragon.bakuman.iu.spotifyscratchaudiostreammitch.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dragon.bakuman.iu.spotifyscratchaudiostreammitch.R;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.adapters.HomeRecyclerAdapter;


public class HomeFragment extends Fragment implements HomeRecyclerAdapter.IHomeSelector {

    private static final String TAG = "HomeFragment";


    // UI Components


    // Vars


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onCategorySelected(int position) {

    }
}















