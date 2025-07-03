package SimpleMusicApp.DTO;
import java.util.List;

public class SpotifySearchResponse {

        private Tracks tracks;

        public Tracks getTracks() { return tracks; }
        public void setTracks(Tracks tracks) { this.tracks = tracks; }

        public static class Tracks {
            private List<Track> items;

            public List<Track> getItems() { return items; }
            public void setItems(List<Track> items) { this.items = items; }
        }

        public static class Track {
            private String name;
            private String preview_url;
            private List<Artist> artists;
            private Album album;

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }

            public String getPreview_url() { return preview_url; }
            public void setPreview_url(String preview_url) { this.preview_url = preview_url; }

            public List<Artist> getArtists() { return artists; }
            public void setArtists(List<Artist> artists) { this.artists = artists; }

            public Album getAlbum() { return album; }
            public void setAlbum(Album album) { this.album = album; }
        }

        public static class Artist {
            private String name;
            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
        }

        public static class Album {
            private String name;
            private List<Image> images;

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }

            public List<Image> getImages() { return images; }
            public void setImages(List<Image> images) { this.images = images; }
        }

        public static class Image {
            private String url;
            public String getUrl() { return url; }
            public void setUrl(String url) { this.url = url; }
        }
    }

