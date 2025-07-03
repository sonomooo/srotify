package SimpleMusicApp.controller;

import SimpleMusicApp.DTO.MusicSampleInfo;
import SimpleMusicApp.DTO.SpotifySearchResponse;
import SimpleMusicApp.service.MusicService;
import SimpleMusicApp.service.SpotifyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Music")
public class MusicController {


    @Autowired
    SpotifyApiService spotifyApiService;

    @Autowired
    MusicService musicService;

    @GetMapping("/findMusic")
    public Object search(@RequestParam String musicName) {
        String apiKey = spotifyApiService.getSpotifyToken();
        SpotifySearchResponse resp = spotifyApiService.searchMusic(apiKey, musicName);

        return resp;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findMusic/sample")
    public List<MusicSampleInfo> searchSample(@RequestParam String musicName){
        String apikey = spotifyApiService.getSpotifyToken();
        SpotifySearchResponse resp = spotifyApiService.searchMusic(apikey, musicName);

        List<MusicSampleInfo> result = new ArrayList<>();
        if (resp != null && resp.getTracks() != null && resp.getTracks().getItems() != null){
            for (SpotifySearchResponse.Track t : resp.getTracks().getItems()){
               String title = t.getName();
               String artist = (t.getAlbum() != null && t.getAlbum().getImages() != null && !t.getAlbum().getImages().isEmpty())
                                                                  ? t.getAlbum().getImages().get(0).getUrl()
                        : null;
               String album = t.getArtists() != null && !t.getArtists().isEmpty() ? t.getArtists().get(0).getName() : "Unknown";
               String albumImageUrl =  t.getPreview_url();
              

               String previewUrl = t.getPreview_url();

                result.add(new MusicSampleInfo(title, artist, album, albumImageUrl, previewUrl));

                if (previewUrl != null){
                    result.add(new MusicSampleInfo(title, artist, album, albumImageUrl, previewUrl));
                }
                }
            }
        return result;
        }


}