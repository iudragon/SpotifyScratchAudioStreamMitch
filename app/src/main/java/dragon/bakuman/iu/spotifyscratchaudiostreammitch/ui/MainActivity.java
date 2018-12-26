package dragon.bakuman.iu.spotifyscratchaudiostreammitch.ui;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import dragon.bakuman.iu.spotifyscratchaudiostreammitch.R;


public class MainActivity extends AppCompatActivity implements IMainActivity {

    private static final String TAG = "MainActivity";

    //UI Components
    private ProgressBar mProgressBar;


    // Vars


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.progress_bar);

        testHomeFragment();

    }

    private void testHomeFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, HomeFragment.newInstance()).commit();


    }


    @Override
    public void hideProgressBar() {

        mProgressBar.setVisibility(View.GONE);

    }

    @Override
    public void showPrrogressBar() {

        mProgressBar.setVisibility(View.VISIBLE);

    }
}


















