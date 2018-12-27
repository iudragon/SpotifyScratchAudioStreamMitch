package dragon.bakuman.iu.spotifyscratchaudiostreammitch.ui;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import dragon.bakuman.iu.spotifyscratchaudiostreammitch.R;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.models.Artist;
import dragon.bakuman.iu.spotifyscratchaudiostreammitch.util.MainActivityFragmentManager;


public class MainActivity extends AppCompatActivity implements IMainActivity
{

    private static final String TAG = "MainActivity";

    //UI Components
    private ProgressBar mProgressBar;

    // Vars


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.progress_bar);

        loadFragment(HomeFragment.newInstance(), true);
    }

    private void loadFragment(Fragment fragment, boolean lateralMovement){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(lateralMovement){
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
        }

        String tag = "";
        if(fragment instanceof HomeFragment){
            tag = getString(R.string.fragment_home);
        }
        else if(fragment instanceof CategoryFragment){
            tag = getString(R.string.fragment_category);
            transaction.addToBackStack(tag);
        }
        else if(fragment instanceof PlaylistFragment){
            tag = getString(R.string.fragment_playlist);
            transaction.addToBackStack(tag);
        }
        transaction.add(R.id.main_container, fragment, tag);
        transaction.commit();

        MainActivityFragmentManager.getInstance().addFragment(fragment);

        showFragment(fragment, false);
    }

    private void showFragment(Fragment fragment, boolean backwardsMovement){
        // Show selected fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(backwardsMovement){
            transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        }
        transaction.show(fragment);
        transaction.commit();

        // hide the others
        for(Fragment f: MainActivityFragmentManager.getInstance().getFragments()){
            if(f != null){
                if(!f.getTag().equals(fragment.getTag())){
                    FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                    t.hide(f); // will not destroy fragment
                    t.commit();
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        ArrayList<Fragment> fragments = new ArrayList<>(MainActivityFragmentManager.getInstance().getFragments());
        if(fragments.size() > 1){
            FragmentTransaction t = getSupportFragmentManager().beginTransaction();
            t.remove(fragments.get(fragments.size() - 1)); // destroy fragment
            t.commit();
            MainActivityFragmentManager.getInstance().removeFragment(fragments.size() - 1);
            showFragment(fragments.get(fragments.size() - 2), true);
        }
        super.onBackPressed();
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}



