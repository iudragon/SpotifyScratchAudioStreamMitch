package dragon.bakuman.iu.spotifyscratchaudiostreammitch.ui;

import dragon.bakuman.iu.spotifyscratchaudiostreammitch.models.Artist;

public interface IMainActivity {

    void showProgressBar();

    void hideProgressBar();

    void onCategorySelected(String category);

    void onArtistSelected(String category, Artist artist);

    void setActionBarTitle(String title);
}