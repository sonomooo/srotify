package SimpleMusicApp.controller;

import SimpleMusicApp.service.MusicService;
import SimpleMusicApp.service.SpotifyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Music")
public class MusicController {


    @Autowired
    SpotifyApiService spotifyApiService;

    @Autowired
    MusicService musicService;

    @GetMapping("/findMusic/{musicName}")
    public void search(@PathVariable String musicName){
        String apiKey = spotifyApiService.getSpotifyToken();
        musicService.findMusic(musicName, apiKey);
    }

}
