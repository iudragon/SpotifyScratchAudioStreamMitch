package dragon.bakuman.iu.spotifyscratchaudiostreammitch.models;

public class Artist  {

    private String title;
    private String image;
    private String artist_id;

    public Artist(String title, String image, String artist_id) {
        this.title = title;
        this.image = image;
        this.artist_id = artist_id;
    }

    public Artist() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(String artist_id) {
        this.artist_id = artist_id;
    }
}
