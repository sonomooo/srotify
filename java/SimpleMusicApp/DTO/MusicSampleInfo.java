package SimpleMusicApp.DTO;

public class MusicSampleInfo {
    private String title;
    private String artist;
    private String album;
    private String albumImageUrl;
    private String previewUrl;

    public MusicSampleInfo(String album, String albumImageUrl, String artist, String previewUrl, String title) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.albumImageUrl = albumImageUrl;
        this.previewUrl = previewUrl;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbumImageUrl() {
        return albumImageUrl;
    }

    public void setAlbumImageUrl(String albumImageUrl) {
        this.albumImageUrl = albumImageUrl;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
