package SimpleMusicApp.controller;

import SimpleMusicApp.DTO.YoutubeMusicBox;
import SimpleMusicApp.domain.Score;
import SimpleMusicApp.service.YoutubeGetMusicService;
import SimpleMusicApp.service.YoutubeGetOAuthToken;
import SimpleMusicApp.service.YoutubeService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/youtube")
public class YoutubeController {

    @Autowired
    YoutubeService youtubeService;

    @Autowired
    YoutubeGetOAuthToken youtubeGetOAuthToken;

    @Autowired
    YoutubeGetMusicService youtubeGetMusicService;

    @GetMapping("/getYoutubeScore")
    public Score getYoutubeScore(@RequestParam String songName){
        return youtubeService.getYoutubeScore(songName);
    }

    @GetMapping("/getYoutubeToken")
    public String getToken() throws IOException, InterruptedException {
        String OAuth = youtubeGetOAuthToken.getOAuth();
        return youtubeGetOAuthToken.getAccessToken(OAuth);
    }

    @GetMapping("/getYoutubeMusic")
    public void getMusic(@RequestParam String songName){
        System.out.println("접속완료");
        YoutubeMusicBox getInfo = youtubeGetMusicService.getYoutubeMusic(songName);
        System.out.println("정보확인");
    }
}
