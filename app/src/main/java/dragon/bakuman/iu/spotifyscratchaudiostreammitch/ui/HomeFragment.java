package dragon.bakuman.iu.spotifyscratchaudiostreammitch.ui;


import android.content.Context;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;

import dragon.bakuman.iu.spotifyscratchaudiostreammitch.R;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.adapters.HomeRecyclerAdapter;


public class HomeFragment extends Fragment implements
        HomeRecyclerAdapter.IHomeSelector {

    private static final String TAG = "HomeFragment";


    // UI Components
    private RecyclerView mRecyclerView;

    // Vars
    private HomeRecyclerAdapter mAdapter;
    private ArrayList<String> mCategories = new ArrayList<>();
    private IMainActivity mIMainActivity;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            mIMainActivity.setActionBarTitle(getString(R.string.categories));
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initRecyclerView(view);
        mIMainActivity.setActionBarTitle(getString(R.string.categories));
    }

    private void initRecyclerView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new HomeRecyclerAdapter(mCategories, getActivity(), this);
        mRecyclerView.setAdapter(mAdapter);

        if (mCategories.size() == 0) {

            retrieveCategories();

        }
    }

    public void retrieveCategories() {
        mIMainActivity.showProgressBar();

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        DocumentReference ref = firestore
                .collection(getString(R.string.collection_audio))
                .document(getString(R.string.document_categories));

        ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    HashMap<String, String> categoriesMap = (HashMap) doc.getData().get(getString(R.string.field_categories));
                    mCategories.addAll(categoriesMap.keySet());
                }
                updateDataSet();
            }
        });

    }

    private void updateDataSet() {
        mAdapter.notifyDataSetChanged();
        mIMainActivity.hideProgressBar();
    }

    @Override
    public void onCategorySelected(int position) {
        mIMainActivity.onCategorySelected(mCategories.get(position));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIMainActivity = (IMainActivity) getActivity();
    }
}



