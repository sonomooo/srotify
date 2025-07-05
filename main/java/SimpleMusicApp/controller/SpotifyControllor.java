package SimpleMusicApp.controller;

import SimpleMusicApp.service.SpotifyApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spotify")
public class SpotifyControllor {

    SpotifyApiService spotifyApiService;

    public SpotifyControllor(SpotifyApiService spotifyApiService) {
        this.spotifyApiService = spotifyApiService;
    }

    @GetMapping("/getApi")
    public String getApi(){
        String apiToken = spotifyApiService.getSpotifyToken();
        System.out.println(apiToken);
        return apiToken;
    }

}
